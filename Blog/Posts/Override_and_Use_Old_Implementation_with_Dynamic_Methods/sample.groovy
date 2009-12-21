def savedToUpperCase = String.metaClass.getMetaMethod('toUpperCase', [] as Class[])
String.metaClass.toUpperCase = { -> 
    def result = savedToUpperCase.invoke(delegate)    
    if (delegate =~ /Groovy/) {
        result + ' Oh, yeah man! Groooovy...'
    } else {
        result
    }
}

assert 'A SIMPLE STRING' == 'A simple string'.toUpperCase()
assert 'THIS IS GROOVY. Oh, yeah man! Groooovy...' == 'This is Groovy.'.toUpperCase()
