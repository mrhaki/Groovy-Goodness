class User {
    String username
    boolean active

    boolean asBoolean() { 
        active
    }
}

assert new User(username: 'mrhaki', active: true)
assert !new User(username: 'mrhaki', active: false)

// We can also add the asBoolean method with metaClass.
String.metaClass.asBoolean = {
    delegate == /sure/
}
assert !'true'
assert 'sure'
