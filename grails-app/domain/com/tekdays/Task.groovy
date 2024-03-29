package com.tekdays

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task.class)
    String title
    String notes
    TekUser assignedTo
    Date dueDate
    TekEvent event
    boolean completed

    static constraints = {
        title blank: false
        notes blank: true, nullable: true, maxSize: 5000
        assignedTo nullable: true
        dueDate nullable: true
        completed nullable:true
    }

    static belongsTo = TekEvent
}
