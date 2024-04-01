import com.tekdays.TekUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_tekUser_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tekUser/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'fullName', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("tekUser.fullName.label"),'default':("Full Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("fullName"),'required':(""),'value':(tekUserInstance?.fullName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'userName', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("tekUser.userName.label"),'default':("User Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("userName"),'required':(""),'value':(tekUserInstance?.userName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'email', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("tekUser.email.label"),'default':("Email")],-1)
printHtmlPart(2)
invokeTag('textField','g',28,['name':("email"),'required':(""),'value':(tekUserInstance?.email)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'website', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("tekUser.website.label"),'default':("Website")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("website"),'required':(""),'value':(tekUserInstance?.website)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'bio', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("tekUser.bio.label"),'default':("Bio")],-1)
printHtmlPart(2)
invokeTag('textArea','g',46,['name':("bio"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'required':(""),'value':(tekUserInstance?.bio)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: tekUserInstance, field: 'password', 'error'))
printHtmlPart(8)
invokeTag('message','g',52,['code':("tekUser.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('textField','g',55,['name':("password"),'required':(""),'value':(tekUserInstance?.password)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710503868427L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
