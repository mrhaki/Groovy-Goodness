import groovy.transform.Field

String stringValue = 'I am typed without @Field.'
def i = 42
@Field String stringField = 'I am typed with @Field.'
counter = 0 // No explicit type definition.

def runIt() {
    try {
        assert stringValue == 'I am typed without @Field.'
    } catch (e) {
        assert e instanceof MissingPropertyException
    }
    try {
        assert i == 42
    } catch (e) {
        assert e instanceof MissingPropertyException
    }
    
    assert stringField == 'I am typed with @Field.'
    
    assert counter++ == 0
}

runIt()

assert stringValue == 'I am typed without @Field.'
assert stringField == 'I am typed with @Field.'
assert i == 42
assert counter == 1
