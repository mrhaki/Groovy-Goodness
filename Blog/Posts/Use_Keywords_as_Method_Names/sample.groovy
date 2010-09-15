class User {

    String username
    
    String 'switch'() {
        username = username.reverse()
    }

}

def u = new User(username: 'mrhaki')
assert 'ikahrm' == u.switch()
