def text = 'Just saying: "Groovy is gr8!"'

// Return all characters before the first quote.
assert text.takeBefore('"') == 'Just saying: '
// Return everything after the colon.
assert text.takeAfter(': ') == '"Groovy is gr8!"'
// Return everything between two quotes.
assert text.takeBetween('"') == 'Groovy is gr8!'
// Return text between is and !.
assert text.takeBetween('is', '!') == ' gr8'

// When no value can be found
// an empty string is returned.
assert text.takeBefore('?') == ''
assert text.takeAfter('Java') == ''
assert text.takeBetween('-') == ''
assert text.takeBetween('[', '/') == ''

def sample = 'JVM languages are "Groovy", "Clojure", "Java".'

assert sample.takeBetween('"') == 'Groovy'
// We can also specify which occurrence we 
// want for a text between same strings.
assert sample.takeBetween('"', 0) == 'Groovy'
assert sample.takeBetween('"', 1) == 'Clojure'
assert sample.takeBetween('"', 2) == 'Java'


def users = "Users: [mrhaki], [hubert]"

assert users.takeBetween('[', ']') == 'mrhaki'
// We can also specify which occurrence we 
// want for a text between to strings.
assert users.takeBetween('[', ']', 0) == 'mrhaki'
assert users.takeBetween('[', ']', 1) == 'hubert'
// When no occurrence an empty string is returned.
assert users.takeBetween('[', ']', 2) == ''
