class SimpleEvent {
    @Delegate Date when
    @Delegate List<String> attendees = []
    int maxAttendees = 0
    String description
}

def event = new SimpleEvent(when: new Date() + 7, description: 'Small Groovy seminar', maxAttendees: 2)

assert 0 == event.size()  // Delegate to List.size()
assert event.after(new Date())  // Delegate to Date.after()
assert 'Small Groovy seminar' == event.description
assert 2 == event.maxAttendees

event << 'mrhaki' << 'student1'  // Delegate to List.leftShift()
assert 2 == event.size()
assert 'mrhaki' == event[0]

event -= 'student1'  // Delegate to List.minus()
assert 1 == event.size()

class SimpleEvent {
    @Delegate Date when
    @Delegate List<String> attendees = []
    int maxAttendees = 0
    String description

    boolean add(Object value) {
        if (attendees.size() < maxAttendees) {
            return attendees.add(value)
        } else {
            throw new IllegalArgumentException("Maximum of ${maxAttendees} attendees exceeded.")
        }
    }
}

def event = new SimpleEvent(when: new Date() + 7, description: 'Small Groovy seminar', maxAttendees: 2)
event << 'mrhaki' << 'student1'

try {
    event << 'three is a crowd.'
    assert false
} catch (IllegalArgumentException e) {
    assert 'Maximum of 2 attendees exceeded.' == e.message
}
