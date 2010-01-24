class User {
    String username
}

User.metaClass.getProperty = { String propName ->
    def meta = User.metaClass.getMetaProperty(propName)
    if (meta) {
        meta.getProperty(delegate)
    } else {
        'Dynamic property for User'
    }
}

def mrhaki = new User(username: 'mrhaki')
def hubert = new User(username: 'hubert')

assert 'mrhaki' == mrhaki.username
assert 'Dynamic property for User' == mrhaki.fullname
