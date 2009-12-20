String simple() {
    42
}
assert 'java.lang.String' == simple().class.name 
assert '42' == simple()

class User {
    String name, email
}

User createUser() { 
    [name: 'mrhaki', email: 'mail@host.com']
}
assert createUser() instanceof User
assert 'mrhaki' == createUser().name
assert 'mail@host.com' == createUser().email
