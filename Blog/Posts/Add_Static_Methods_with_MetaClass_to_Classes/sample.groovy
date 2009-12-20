class User {
    String username, email
    String toString() { "$username, $email" }
}

User.metaClass.static.new = { u, e ->
    new User(username: u, email: e)
}

def u = User.new('mrhaki', 'mail@host.com')
assert 'mrhaki' == u.username
assert 'mail@host.com' == u.email
?
