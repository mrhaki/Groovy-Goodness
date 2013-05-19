class Event {
    List&lt;Person&gt; attendees = []
    List&lt;Session&gt; sessions = []

    Event leftShift(final Person person) {
        attendees &lt;&lt; person
        this
    }
    
    Event leftShift(final Session session) {
        sessions &lt;&lt; session
        this
    }  
}
class Session { String title }
class Person { String name }

final Event gr8Conf = new Event()
gr8Conf &lt;&lt; new Person(name: 'mrhaki') &lt;&lt; new Session(title: /Groovy's Hidden Gems/)

assert gr8Conf.attendees.size() == 1
assert gr8Conf.sessions.size() == 1
assert gr8Conf.attendees[0].name == 'mrhaki'
assert gr8Conf.sessions[0].title == "Groovy's Hidden Gems"
