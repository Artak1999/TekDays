package com.tekdays

import org.hibernate.envers.Audited

@Audited
class TekUser {

    String fullName
    String userName
    String password
    String email
    String website
    String bio
    Date dateCreated
    Date lastUpdated

    String toString(){
        fullName
    }

    static constraints = {
        fullName()
        userName()
        email email: true, blank: false, unique: true
        website()
        bio maxSize: 5000
    }
}
