import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@Builder(builderStrategy = SimpleStrategy, prefix = 'assign')
class Message {
    String from, to, subject, body
}

def message = new Message()
        .assignFrom('mrhaki@mrhaki.com')  // Method per property.
        .assignTo('mail@host.nl')
        .assignSubject('Sample mail')
        .assignBody('Groovy rocks!')

assert message.body == 'Groovy rocks!'
assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Sample mail'
assert message.to == 'mail@host.nl'
