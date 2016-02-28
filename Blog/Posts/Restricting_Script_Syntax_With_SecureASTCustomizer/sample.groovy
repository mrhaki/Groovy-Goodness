package com.mrhaki.blog

import org.codehaus.groovy.control.customizers.SecureASTCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.control.MultipleCompilationErrorsException

import static org.codehaus.groovy.control.customizers.SecureASTCustomizer.ExpressionChecker
import static org.codehaus.groovy.control.customizers.SecureASTCustomizer.StatementChecker


// Define SecureASTCustomizer.
final SecureASTCustomizer astCustomizer = new SecureASTCustomizer()

// Define expression checker to deny 
// usage of variable names with length of 1.
def smallVariableNames = { expr -&gt;
    if (expr instanceof VariableExpression) {
        expr.variable.size() &gt; 1
    } else {
        true
    }
} as ExpressionChecker

astCustomizer.addExpressionCheckers smallVariableNames


// In for loops the collection name
// can only be 'names'.
def forCollectionNames = { statement -&gt;
    if (statement instanceof ForStatement) {
        statement.collectionExpression.variable == 'names'
    } else {    
        true
    }
} as StatementChecker

astCustomizer.addStatementCheckers forCollectionNames


// Add SecureASTCustomizer to configuration for shell.
final CompilerConfiguration conf = new CompilerConfiguration()
conf.addCompilationCustomizers(astCustomizer)

// Create shell with given configuration.
final GroovyShell shell = new GroovyShell(conf)

// All valid script.
final result = shell.evaluate '''
def names = ['Groovy', 'Grails']
for (name in names) {
    print "$name rocks! " 
}

def s1 = 'Groovy'
def s2 = 'rocks'
"$s1 $s2!"
'''

assert result == 'Groovy rocks!'

// Some invalid scripts.
try {
    // Variable s has length 1, which is not allowed.
    shell.evaluate '''
    def s = 'Groovy rocks'
    s
    '''
} catch (MultipleCompilationErrorsException e) {
    assert e.message.contains('Expression [VariableExpression] is not allowed: s')
}


try {
    // Only names as collection expression is allowed.
    shell.evaluate '''
    def languages = ['Groovy', 'Grails']
    for (name in languages) {
        println "$name rocks!" 
    }
    '''
} catch (MultipleCompilationErrorsException e) {
    assert e.message.contains('Statement [ForStatement] is not allowed')
}
