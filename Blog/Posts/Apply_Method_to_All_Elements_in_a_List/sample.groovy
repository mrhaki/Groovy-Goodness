class User { 
    String name 
    String aloud() { name.toUpperCase() }
    String toString() { name }
}

def users = [new User(name: 'mrhaki'), new User(name: 'hubert')]

assert ['mrhaki', 'hubert'] == users*.toString()
assert ['MRHAKI', 'HUBERT'] == users*.aloud()
assert ['mrhaki', 'hubert'] == users.collect { it.toString() }
assert ['MRHAKI', 'HUBERT'] == users.collect { it.aloud() }
