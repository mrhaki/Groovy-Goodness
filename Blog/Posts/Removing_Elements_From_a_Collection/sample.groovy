def list = ['Groovy', 42, 'gr8!', 5.2, new Date()]

// Groovy adds retainAll method
// to remove items from collection
// that do not apply to the condition we 
// define in the closure and keep those
// items that do apply to the condition.
list.retainAll { it instanceof String }

// All values that are not a String
// object are removed.
// Remember the collection we use the
// retainAll method on is changed.
assert list == ['Groovy', 'gr8!']


def values = ['Hello', 'world', 'from', 'Groovy']

// Groovy adds retainAll(Object[]) 
// to keep multiple elements
// in a collection and remove all
// the other elements.
values.retainAll(['world', 'Hello'] as Object[])

assert values.join(' ') == 'Hello world'
