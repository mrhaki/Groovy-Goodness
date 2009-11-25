def user = new Expando(username: 'mrhaki')
assert 'mrhaki' == user.username

// Add an extra property.
user.email = 'email@host.com'
assert 'email@host.com' == user.email

// Assign closure as method. The closure can
// take parameters.
user.printInfo = { writer ->
    writer << "Username: $username"
    writer << ", email: $email"
}

def sw = new StringWriter()
user.printInfo(sw)
assert 'Username: mrhaki, email: email@host.com' == sw.toString()
