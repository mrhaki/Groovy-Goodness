class User {
    boolean enabled
    
    Boolean asBoolean() {
        enabled
    }
}

def items = [0, false, null, [], [:], '', new User(enabled: false), 'Groovy rocks!', 101]

assert items.find() == 'Groovy rocks!'

assert items.findAll() == ['Groovy rocks!', 101]
