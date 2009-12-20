result = []

// Mystic expressions: (see assert for outcome)
say hello:world {
    'Groovy'
}
say hello:world { 
    'Java' 
}

assert "Say 'Hello Groovy world!'" == result[0]
assert "Say 'Hello Java world!'" == result[1]

// Actually we are invoking:
// say([hello: world({ 'Groovy' })])
// say([hello: world({ 'Java' })])
// We notice two methods: save(map) and world(closure).

// The methods:
def world(callable) {
    def result = callable()
    "Hello $result world!"
}

def say(map) {
    result &lt;&lt; "Say '${map.hello}'"
}
