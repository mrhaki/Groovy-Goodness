import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

class Message {
    String from, to, subject, body
}

@Builder(builderStrategy = ExternalStrategy, forClass = Message,
        prefix = 'assign', buildMethodName = 'create',
        includes = 'from,subject')
class MessageBuilder {}

def message = new MessageBuilder()
        .assignFrom('mrhaki@mrhaki.com')
        .assignSubject('Groovy 2.3 is released')
        .create()

assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Groovy 2.3 is released'
