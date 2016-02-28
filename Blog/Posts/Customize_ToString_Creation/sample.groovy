package com.mrhaki.blog.groovy

import groovy.transform.*

@ToString(cache=true /* default false */)
class Course {
    String title
    Integer maxAttendees
}

Course course = new Course(title: 'Groovy 101', maxAttendees: 200)

assert course.toString() == 'com.mrhaki.blog.groovy.Course(Groovy 101, 200)'

// Value change will not be reflected in toString().
course.title = 'Grails with REST'

assert course.toString() == 'com.mrhaki.blog.groovy.Course(Groovy 101, 200)'
assert course.title == 'Grails with REST'
