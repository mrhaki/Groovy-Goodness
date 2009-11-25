def myvar = 42
assert myvar instanceof Integer

myvar = 'I am a String'  // String assignment changes type.
assert myvar instanceof String

String s = 'I am String'
assert s instanceof String

s = new Integer(100)  // Surprise, surprise, value is converted to String!
assert s instanceof String

int i = 42
assert i instanceof Integer

try {
    i = 'test'  // Cannot assign String value to Integer.
} catch (e) {
    assert e instanceof org.codehaus.groovy.runtime.typehandling.GroovyCastException
}
