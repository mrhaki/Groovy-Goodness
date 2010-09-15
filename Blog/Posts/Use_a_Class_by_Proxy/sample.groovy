class User {
    String name
    String email
    String password

    String displayName() { name }
}

class UserProxy extends groovy.util.Proxy {
    List fields

    // Override getProperty for custom behavior by the proxy.
    Object getProperty(String propertyName) {
        if (propertyName in fields) {
            getAdaptee().getProperty(propertyName)
        } else {
            throw new MissingPropertyException("Unknown property $propertyName")
        }
    }
}

def user = new User(name: 'mrhaki', email: 'private@localhost', password: 'secret')
def userProxy= new UserProxy(fields: ['name']).wrap(user)  // Create proxy for user instance.

assert 'mrhaki' == userProxy.name
try {
    userProxy.email
    assert false
} catch (MissingPropertyException e) {
    assert 'Unknown property email' == e.message
}
assert 'mrhaki' == userProxy.displayName()  // Use original method.
