package com.mrhaki.blog.groovy

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

@Builder(builderStrategy = InitializerStrategy,
        excludes = 'body',
        builderMethodName = 'creator')
class Message {
    String from, to, subject, body
}

// With @CompileStatic the compiler will check
// that all properties defined in the @Builder
// configuration are set. This way we can
// implement required properties for a class
// that need to be set before the object can
// be created.
@CompileStatic
def createMessage() {
    def messageInit = Message.creator()
            .from('mrhaki@mrhaki.com')
            .to('mail@host.nl')
            .subject('Groovy 2.3 is released')

    def message = new Message(messageInit)
    message
}

final Message message = createMessage()

assert message.from == 'mrhaki@mrhaki.com'
assert message.subject == 'Groovy 2.3 is released'
