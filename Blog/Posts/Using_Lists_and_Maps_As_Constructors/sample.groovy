// Default constructor invocation:
def url1 = new URL('http', 'www.mrhaki.com', 80, '/')
assert 'http' == url1.protocol
assert 'www.mrhaki.com' == url1.host
assert 80 == url1.port
assert '/' == url1.file
assert '/' == url1.path

// Explicit coersion with as keyword:
def url2 = ['http', 'www.mrhaki.com', 80, '/'] as URL
assert 'http' == url1.protocol
assert 'www.mrhaki.com' == url2.host
assert 80 == url2.port
assert '/' == url2.file
assert '/' == url2.path

// Implicit coersion by type of variable:
URL url3 = ['http', 'www.mrhaki.com', 80, '/'] 
assert 'http' == url3.protocol
assert 'www.mrhaki.com' == url3.host
assert 80 == url3.port
assert '/' == url3.file
assert '/' == url3.path    

// GroovyBean: Groovy creates a constructor
// that takes a map as parameter.
class Sample {
    Integer age 
    String name
}

def s1 = new Sample([age: 36, name: 'mrhaki'])
assert 36 == s1.age
assert 'mrhaki' == s1.name

// Explicit coersion with as keyword:
def s2 = [age: 36, name: 'mrhaki'] as Sample
assert 36 == s2.age
assert 'mrhaki' == s2.name

// Implicit coersion (by type of variable):
Sample s3 = [age: 36, name: 'mrhaki']
assert 36 == s3.age
assert 'mrhaki' == s3.name
