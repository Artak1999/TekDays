package com.tekdays

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.mail.MailService
import groovy.json.JsonSlurper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional()
class TekUserController {

    //static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", getAllUsers: "GET", createUser: "POST",
                             getUserById: "GET", updateUser: "PUT", deleteUser: "DELETE"]
    private static final Logger LOGGER = LoggerFactory.getLogger(TekUserController.class)
    def datatablesSourceService
    MailService mailService

    //REST http://localhost:8080/TekDays/tekUser/getAllUsers.json
    //REST http://localhost:8080/TekDays/tekUser/getAllUsers.xml
    //curl http://localhost:8080/TekDays/tekUser/getAllUsers
    def getAllUsers = {
        def tekUsers = TekUser.list()
        if (tekUsers) {
            withFormat {
                json {
                    def jsonify = tekUsers as JSON
                    jsonify.prettyPrint = true
                    render jsonify
                }
                xml {
                    render tekUsers as XML
                }
            }
        } else response.sendError 404
    }

    //REST http://localhost:8080/TekDays/tekUser/getUserById/1.json
    //REST http://localhost:8080/TekDays/tekUser/getUserById/1.xml
    //curl http://localhost:8080/TekDays/tekUser/getUserById/1
    @Transactional
    def getUserById(Long id) {
        TekUser tekUser = TekUser.findById(id)
        if (tekUser) {
            withFormat {
                json {
                    def jsonify = tekUser as JSON
                    jsonify.prettyPrint = true
                    render jsonify
                }
                xml {
                    render(tekUser as XML)
                }
            }
        } else response.sendError 404
    }

    //REST curl -X POST -H 'Content-Type: application/json' http://localhost:8080/TekDays/tekUser/createUser -d
    //      '{ "fullName":"name","userName":"poxos","email":"p@mail.ru","website":"http://google.com","bio":"asdsadadsadsadaas","password":"578"}'
    @Transactional
    def createUser() {
        def slurped = new JsonSlurper()
        def requestMap = slurped.parseText(request?.JSON?.toString())
        def fullName = requestMap["fullName"]
        def userName = requestMap["userName"]
        def email = requestMap["email"]
        def website = requestMap["website"]
        def bio = requestMap["bio"]
        def password = requestMap["password"]
        TekUser tekUser = new TekUser(fullName: fullName, userName: userName, email: email, website: website, bio: bio, password: password)
        tekUser.save flush: true
        render("NAME= ${tekUser.fullName}") as JSON
    }

    //REST curl -X PUT -H "Content-Type: application/json" http://localhost:8080/TekDays/tekUser/updateUser/19 -d
    //      '{"bio":"Senior Software engineer"}'
    @Transactional
    def updateUser(Long id) {
        TekUser tekUser = TekUser.findById(id)
        def slurped = new JsonSlurper()
        def requestMap = slurped.parseText(request?.JSON?.toString())
        if (tekUser) {
            tekUser.bio = requestMap["bio"]
            tekUser.save(flush: true)
            render(tekUser.toString() + " => Updated")
        } else response.sendError 404
    }

    //REST curl -X DELETE http://localhost:8080/TekDays/tekUser/deleteUserById/19
    @Transactional
    def deleteUserById(Long id) {
        TekUser tekUser = TekUser.findById(id)
        if (tekUser) {
            String userData = tekUser.toString()
            tekUser.delete(flush: true)
            render(userData + " => DELETED")
        } else response.sendError 404
    }

    def registration() {
        TekUser user = new TekUser(params)
        def email = TekUser.findByEmail(user.email)?.email
        if (user?.email == email) {
            LOGGER.info("There is already a user with email {}", user.email)
            redirect(action: "login")
            return
        }
        try {
            mailService.sendMail {
                to user.email
                subject "Email Notification"
                html view: "/email/confirmRegistration", model: [user: user]
            }
        } catch (Exception e) {
            LOGGER.info("**** Error : Sending Job Fail Email:\n******* Cause : " + e.getMessage())
        }
        redirect(action: 'login')
    }


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TekUser.list(params), model: [tekUserInstanceCount: TekUser.count()]
    }

    def dataTablesRenderer() {
        def propertiesToRender = ["fullName", "email", "website", "bio", "password", "id", "id", "id"]
        def entityName = 'TekUser'
        render datatablesSourceService.dataTablesSource(propertiesToRender, entityName, params)
    }

    def show(TekUser tekUserInstance) {
        respond tekUserInstance
    }

    def login() {
        if (params.cName)
            return [cName: params.cName, aName: params.aName]
    }

    def register() {}

    def logout = {
        session.user = null
        redirect(uri: '/')
    }

    def validate() {
        def user = TekUser.findByUserName(params.username)
        if (user && user.password == params.password) {
            session.user = user
            if (params.cName)
                redirect controller: params.cName, action: params.aName
            else
                redirect(uri: '/')
        } else {
            flash.message = "Invalid username and password."
            render view: 'login'
        }
    }

    def revision() {
        def userInstanceId = params.id
        def result = datatablesSourceService.getAuditedUser(params)

        def data = ["userInstanceId": userInstanceId, "result": result]
        [data: data]
    }

    def create() {
        respond new TekUser(params)
    }

    @Transactional
    def save(TekUser tekUserInstance) {
        if (tekUserInstance == null) {
            notFound()
            return
        }

        if (tekUserInstance.hasErrors()) {
            respond tekUserInstance.errors, view: 'create'
            return
        }

        tekUserInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tekUser.label', default: 'TekUser'), tekUserInstance.id])
                redirect tekUserInstance
            }
            '*' { respond tekUserInstance, [status: CREATED] }
        }
    }

    def edit(TekUser tekUserInstance) {
        respond tekUserInstance
    }

    @Transactional
    def update(TekUser tekUserInstance) {
        if (tekUserInstance == null) {
            notFound()
            return
        }

        if (tekUserInstance.hasErrors()) {
            respond tekUserInstance.errors, view: 'edit'
            return
        }

        tekUserInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TekUser.label', default: 'TekUser'), tekUserInstance.id])
                redirect tekUserInstance
            }
            '*' { respond tekUserInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TekUser tekUserInstance) {

        if (tekUserInstance == null) {
            notFound()
            return
        }

        tekUserInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TekUser.label', default: 'TekUser'), tekUserInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekUser.label', default: 'TekUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
