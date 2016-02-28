@groovy.transform.Immutable
class User {
    String name
    int age
}


// Initial list with user defined
// using a map or Object array.
def userList = [
    // User defined as map, keys
    // are properties of User class.
    [name: 'mrhaki', age: 41], 
    
    // Object array with name and
    // age properties for User class.
    ['john', 30] as Object[]
]

// Create constructor reference.
// Result is a closure we can use in our code.
def createUser = User.metaClass.&invokeConstructor

// Invoke the collect method with our
// constructor reference. At the end
// all elements of the userList 
// are converted to new User objects.
def users = userList.collect(createUser)


assert users.name == ['mrhaki', 'john']
assert users.age == [41, 30]
