import groovy.json.JsonBuilder
import groovy.json.StreamingJsonBuilder

// Example class.
@groovy.transform.Immutable
class Villain { 
    String name 
}

// A list of Villain objects that needs to transformed
// to a JSON array.
def list = ['The Joker', 'Penguin', 'Catwoman', 'Harley Quinn'].collect { name -> new Villain(name) }

// We create a new JsonBuilder and 
// then we use the instance implicit
// method call with the list of Villain
// objects as arguments and closure
// to transform each Villain object
// in the root JSON array.
def json1 = new JsonBuilder() 
json1(list) { Villain villain ->
    name villain.name
    initials villain.name.split(' ').collect { it[0].toUpperCase() }.join()
}

assert json1.toString() == '[{"name":"The Joker","initials":"TJ"},{"name":"Penguin","initials":"P"},{"name":"Catwoman","initials":"C"},{"name":"Harley Quinn","initials":"HQ"}]'


// We can use the same implicit
// method call for a list and 
// closure to transform each element
// to a root JSON array.
def json = new StringWriter()
def json2 = new StreamingJsonBuilder(json)
json2(list) { Villain villain -> 
    name villain.name
    initials villain.name.split(' ').collect { it[0].toUpperCase() }.join()
}

assert json.toString() == '[{"name":"The Joker","initials":"TJ"},{"name":"Penguin","initials":"P"},{"name":"Catwoman","initials":"C"},{"name":"Harley Quinn","initials":"HQ"}]'
