def list = ['Groovy', 'is', 'great!']

// Remove last item from list
// with pop().
assert list.pop() == 'great!'
assert list == ['Groovy', 'is']

// Remove last item
// which is now 'is'.
list.pop()

// Add new item to end of
// the list (equivalent for add()).
list.push('rocks!')

assert list == ['Groovy', 'rocks!']
