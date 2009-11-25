class User {
    String name    
    def connections = []

    def speaks(args) {
        connections.find{it.name == args.to.name}.listen(args.saying)
    }

    def meets(user) {
        connections << user
    }

    def listen(text) {
        println "I, $name, am listening to '$text'"
    }

    def greeting() {
        "Hi, I am $name."
    }
}

def mrhaki = new User(name: 'mrhaki')
def hubert = new User(name: 'hubert')

mrhaki.meets hubert  // No parenthesis needed.

println mrhaki.greeting()  // Need to use parenthesis for greeting, otherwise Groovy thinks greeting is a property.
// Output: Hi, I am mrhaki

mrhaki.speaks to: hubert, saying: 'How are you doing?'  // Named parameters.
// Output: I, hubert, am listening to 'How are you doing?'

// Look out with closures as the last element.
// The method can be invoked in several ways.
def list = [1,2,3,4]
list.sum(100, { it * 2 })  // Traditional, all parenthesis and comma.
list.sum(100) { it * 2 }  // Last argument is closure, so can be outside parenthesis and no comma 
list.sum 100, { it * 2 }  // No parenthesis, but with the comma.
