// Original Map structure.
def original = [name: 'mrhaki', age: 42]

// Turn map into String representation:
// [name:mrhaki, age:42]
def mapAsString = original.toMapString()

def map = 
    // Take the String value between
    // the [ and ] brackets.
    mapAsString[1..-2]
        // Split on , to get a List.
        .split(', ')
        // Each list item is transformed
        // to a Map entry with key/value.
        .collectEntries { entry -> 
            def pair = entry.split(':')
            [(pair.first()): pair.last()]
        }
        

assert map.size() == 2
assert map.name == 'mrhaki'
assert map.age == '42'
