interface Nothing { }
class Simple implements Nothing { }

Nothing.metaClass.groovyShoutOut = { -> "Groovy is awesome!" }

def s = new Simple()
assert 'Groovy is awesome!' == s.groovyShoutOut()
