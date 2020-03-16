def list = ['Groovy', 'is', 'great!']
 
// Remove last item from list
// with removeLast().
assert list.removeLast() == 'great!'
assert list == ['Groovy', 'is']
 
// Remove last item which is now 'is'.
list.removeLast()
 
// Add new item to end of the list.
list.add 'rocks!'
 
assert list.join(' ') == 'Groovy rocks!'


/* IMPORTANT */
/* pop() and push() implementations has changed */
/* in Groovy 2.5.0. They now work on the first */
/* item in a List instead of the last. */

// Using pop() we remove the first item
// of a List.
assert list.pop() == 'Groovy'

// And with push we add item to 
// beginning of a List.
list.push 'Spock'

assert list.join(' ') == 'Spock rocks!'
