import groovy.transform.ToString
@ToString(includeNames = true)
class User {
    
    String name
    String alias
    String email
    String website
    
    // Set name.
    def call(final String name) {
        this.name = name
        this
    }
    
    // Use properties from data to assign
    // values to properties.
    def call(final Map data) {
        this.name = data.name ?: name
        this.alias = data.alias ?: alias
        this.email = data.email ?: email
        this.website = data.website ?: website
        this
    }
    
    // Run closure with this object as argument.
    def call(final Closure runCode) {
        runCode(this)
    }
    
}


def mrhaki = 
    new User(
        name: 'Hubert Klein Ikkink',
        alias: 'mrhaki',
        email: 'mrhaki@email.nl',
        website: 'https://www.mrhaki.com')
        
// Invoke the call operator with a String.
// We don't have to explicitly use the
// call method, but can leave out the method name.
// The following statement is the same:
// mrhaki.call('Hubert A. Klein Ikkink')
mrhaki('Hubert A. Klein Ikkink')

// Of course parentheses are optional in Groovy.
// This time we invoke the call method
// that takes a Map arguemnt.
mrhaki email: 'h.kleinikkink@email.nl'

assert mrhaki.name == 'Hubert A. Klein Ikkink'
assert mrhaki.alias == 'mrhaki'
assert mrhaki.email == 'h.kleinikkink@email.nl'
assert mrhaki.website == 'https://www.mrhaki.com'


// We can pass a Closure to the call method where
// the current instance is an argument for the closure.
// By using the call operator we have a very dense syntax.
mrhaki { println it.alias }  // Output: mrhaki

// Example to transform the user properties to JSON.
def json =  mrhaki { 
    new groovy.json.JsonBuilder([vcard: [name: it.name, contact: it.email, online: it.website]]).toString()
} 

assert json == '{"vcard":{"name":"Hubert A. Klein Ikkink","contact":"h.kleinikkink@email.nl","online":"https://www.mrhaki.com"}}'
