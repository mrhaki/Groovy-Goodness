class Person {
    // We must not leave out a modifier,
    // because without a modifier, 
    // Groovy would add
    // a getName and setName method if
    // they are not already available.
    // But Groovy also adds a private modifier
    // for this property and being
    // private it is not accessible from
    // subclasses.
    protected String name

    String getName() {
        "_${name}_"
    }

    void setName(String name) {
        this.name = "*${name}*"
    }
}

class User extends Person {
    String getUsername() {
        // .name will invoke getName().
        "User(${this.name})"
    }

    String getUsernameField() {
        // .@name will access name field.
        "User(${this.@name})"
    }
}

def u = new User(name: 'mrhaki')

assert u.username == 'User(_*mrhaki*_)'
assert u.usernameField == 'User(*mrhaki*)'
assert u.name == '_*mrhaki*_'
assert u.@name == '*mrhaki*'

// Set field value directly
u.@name = 'mrhaki'

assert u.username == 'User(_mrhaki_)'
assert u.usernameField == 'User(mrhaki)'
assert u.name == '_mrhaki_'
assert u.@name == 'mrhaki'
