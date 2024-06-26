package com.tekdays

class TekEvent {

    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description
    String nickname
    static searchable = true
    static hasMany = [volunteers: TekUser,
                      respondents: String,
                      sponsorships: Sponsorship,
                      tasks : Task,
                      messages : TekMessage]

    String toString(){
        "$name, $city"
    }

    static constraints = { // validation rules
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
        volunteers nullable: true
        sponsorships nullable: true
        tasks nullable: true
        messages nullable: true
        nickname nullable: true
    }
}