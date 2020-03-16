def numbers = [10, 20, 30, 40, 50]

assert numbers.average() == 30

// We can use a closure to transform an item
// and the result is used for calculating an average.
assert numbers.average { n -> n / 10 } == 3


def words = ['Groovy', 'three', 'is', 'awesome']

// Use supported Java method reference syntax to first 
// get length of word.
assert words.average(String::size) == 5

// Calculate average number of vowels in the words.
assert words.average { s -> s.findAll(/a|e|i|o|u/).size() } == 2.25
