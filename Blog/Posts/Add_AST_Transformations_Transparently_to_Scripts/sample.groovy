package com.mrhaki.blog

import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import groovy.transform.Canonical

def conf = new CompilerConfiguration()
conf.addCompilationCustomizers(new ASTTransformationCustomizer(Canonical))

def shell = new GroovyShell(conf)
shell.evaluate '''
package com.mrhaki.blog

class User {
    String username, fullname
}

// TupleConstructor is added by Canonical transformation.
def user = new User('mrhaki', 'Hubert A. Klein Ikkink')
// ToString is added by Canonical transformation.
assert user.toString() == 'com.mrhaki.blog.User(mrhaki, Hubert A. Klein Ikkink)'

// AST transformation is also applied to the Script class.
assert this.toString() == 'com.mrhaki.blog.Script1()'
'''
