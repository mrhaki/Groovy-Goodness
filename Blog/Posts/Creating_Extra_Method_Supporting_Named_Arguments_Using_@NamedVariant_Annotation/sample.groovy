import static groovy.test.GroovyAssert.shouldFail

import groovy.transform.NamedVariant
import groovy.transform.NamedParam

class Conference {
    String name, location
}

class ConferenceMaker {
    // Using @NamedVariant to create
    // also an implementation of the make 
    // method with a Map argument to 
    // support named arguments.
    @NamedVariant
    static Conference make(
        @NamedParam(required = true) String name, 
        @NamedParam String location) {
        
        new Conference(name: name, location: location)
    }
}

// The named argument 'name' is required,
// 'location' is optional.
def gr8Conf = ConferenceMaker.make(name: 'Gr8Conf')

assert gr8Conf.name == 'Gr8Conf'

def required = shouldFail(AssertionError) {
    // If we don't specify the required named
    // argument an exception is thrown.
    ConferenceMaker.make(location: 'Copenhagen')
}
assert required.message.contains("Missing required named argument 'name'.")


// With named arguments the order of the arguments
// is not important.
def gr8ConfEU = ConferenceMaker.make(location: 'Copenhagen', name: 'Gr8Conf')

assert gr8ConfEU.name == 'Gr8Conf'
assert gr8ConfEU.location == 'Copenhagen'


shouldFail(MissingMethodException) {
    // Because the original make method is
    // invoked by the generated named arguments make 
    // method, so we get an exception when
    // the type of the named argument is incorrect.
    ConferenceMaker.make(name: 'G' as char)
}
