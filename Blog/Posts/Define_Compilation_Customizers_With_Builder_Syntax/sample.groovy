package com.mrhaki.blog

import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.builder.CompilerCustomizationBuilder
import groovy.transform.*


def conf = new CompilerConfiguration()

// Define CompilerConfiguration using 
// builder syntax.
CompilerCustomizationBuilder.withConfig(conf) {
    ast(TupleConstructor)
    ast(ToString, includeNames: true, includePackage: false)
    
    imports {
        alias 'Inet', 'java.net.URL'
    }
    
    secureAst {
        methodDefinitionAllowed = false
    }
}


def shell = new GroovyShell(conf)
shell.evaluate '''
package com.mrhaki.blog

class User {
    String username, fullname
}

// TupleConstructor is added.
def user = new User('mrhaki', 'Hubert A. Klein Ikkink')

// toString() added by ToString transformation.
assert user.toString() == 'User(username:mrhaki, fullname:Hubert A. Klein Ikkink)'

// Use alias import.
def site = new Inet('http://www.mrhaki.com/')
assert site.text
'''
