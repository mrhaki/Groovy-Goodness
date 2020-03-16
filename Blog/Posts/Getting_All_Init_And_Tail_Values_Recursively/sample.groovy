def letters = ('a'..'d').toList()

assert letters == ['a', 'b', 'c', 'd']

assert letters.init() == ['a', 'b', 'c']
assert letters.tail() == ['b', 'c', 'd']

// Inits returns collection of all init()
// results for an Iterable. The first element
// has the original values, the next element
// the result of init()
// of the previous element and so on until
// an empty List is the result.
assert letters.inits() == [
    ['a', 'b', 'c', 'd'], 
    ['a', 'b', 'c'], 
    ['a', 'b'], 
    ['a'], 
    []]

// Tails returns collection of all tail()
// results for an Iterable. The first element
// has the original values, the next element
// the result of tail()
// of the previous element and so on until
// an empty List is the result.
assert letters.tails() == [
    ['a', 'b', 'c', 'd'], 
    ['b', 'c', 'd'], 
    ['c', 'd'], 
    ['d'], 
    []]
