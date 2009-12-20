interface Simple {}
class Sample implements Simple {
    String info
    String displayInfo() { "info from $Sample.name" }
}

assert 'Sample' == Sample.name
assert 'Sample' == Sample.class.name

def interfaces = Sample.interfaces.name
assert 'Simple' in interfaces
assert 'groovy.lang.GroovyObject' in interfaces

def methods = Sample.methods.name
assert 'setInfo' in methods
assert 'getInfo' in methods
assert 'displayInfo' in methods

def s = new Sample()
assert 'info from Sample' == s.displayInfo()
