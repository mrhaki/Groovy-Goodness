@groovy.transform.ToString
class SimpleEvent {
    @Delegate(excludes=['after']) Date start
    @Delegate(excludes=['before']) Date end
    String description
}

def event = new SimpleEvent(description: 'Groovy seminar',
                            start: nextWeek, 
                            end: nextWeek + 3)

// Delegate to Date start property.
assert event.before(nextWeek + 1)
assert !event.before(nextWeek - 1)
assert !event.before(today)

// Delegate to Date end property.
assert event.after(today)        
assert event.after(nextWeek + 1)     
assert !event.after(nextWeek + 4)        


// Helper get methods:
def getToday() {
    new Date().clearTime()
}

def getNextWeek() {
    today + 7
}
