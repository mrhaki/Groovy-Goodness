// If alias is set in constructor use it, otherwise
// calculate alias value based on name value.
@MapConstructor(post = { alias = alias ?: name.split().collect { it[0] }.join() })
class Person {
    final String name // AST transformation supports read-only properties.
    final String alias
    List&lt;String&gt; likes
}

// Set alias in constructor.
def mrhaki = 
    new Person(
        name: 'Hubert Klein Ikkink', 
        alias: 'mrhaki', 
        likes: ['Groovy', 'Gradle'])
        
assert mrhaki.name == 'Hubert Klein Ikkink'
assert mrhaki.alias == 'mrhaki'
assert mrhaki.likes == ['Groovy', 'Gradle']

// Don't set alias via constructor.
def hubert = 
    new Person(
        name: 'Hubert A. Klein Ikkink')
        
assert hubert.name == 'Hubert A. Klein Ikkink'
assert hubert.alias == 'HAKI'
assert !hubert.likes
