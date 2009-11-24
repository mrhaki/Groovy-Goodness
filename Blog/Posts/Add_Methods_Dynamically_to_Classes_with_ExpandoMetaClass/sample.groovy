// We add the method rightShift to the List class. 
// The implementation is simply calling the remove method of List with
// the provided argument.
List.metaClass.rightShift {
    delegate.remove it
}

def list = ['one', 'two', 'three', 'four']
assert 4 == list.size()

list.rightShift 'two'
assert 3 == list.size()
assert ['one', 'three', 'four'] == list

// Operator overloading in action: rightShift is &gt;&gt;
list &gt;&gt; 'one'
assert 2 == list.size()
assert ['three', 'four'] == list


// We can also add behaviour to a specific instance instead of class.
// Notice we use the instance list instead of class List to assign 
// method groovy to metaClass property.
list.metaClass.groovy {
    delegate.collect { it + ' groovy' }
}

assert ['three groovy', 'four groovy'] == list.groovy()

def newList = ['a', 'b']
try {
    newList.groovy()  // groovy method was added to list instance not List class.
    assert false
} catch (e) {
    assert e instanceof MissingMethodException
}
