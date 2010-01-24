class User {
    String username
    String language= 'Java'
    String toString() { "$username likes $language" }
}

def users = ['mrhaki', 'Hubert A. Klein Ikkink', 'Sample'].collect { new User(username: it) }
assert ['mrhaki likes Java', 'Hubert A. Klein Ikkink likes Java', 'Sample likes Java'] == users.collect { it.toString() }
// Last statement of collect closure is new list item.
def usersGroovy = users.collect { user ->
    if (user.username != 'Sample') {
        user.language = 'Groovy'
    }
    user  // Return user object so new list contains user objects!
}
assert ['mrhaki likes Groovy', 'Hubert A. Klein Ikkink likes Groovy', 'Sample likes Java'] == usersGroovy.collect { it.toString() }

// Last statement of collect closure is new list item.
// In this case we only return a String.
def usersClojure = users.collect { user ->
    user.language = 'Clojure'
}
assert ['Clojure', 'Clojure', 'Clojure'] == usersClojure
