// Range is defined based on int
// value of character.
def characters = 'A'..'F'

assert characters.from == 'A'
assert characters.to == 'F'
assert characters.toList() == ['A', 'B', 'C', 'D', 'E', 'F']
assert characters.step(2) == ['A', 'C', 'E']


// We can create a reverse range
// also based on the int value
// of the character.
def sample = '&amp;'..'!'

assert sample.toList() == ['&amp;', '%', '$', '#', '&quot;', '!']
assert sample.reverse
assert sample.from == '!'
assert sample.to == '&amp;'


// We can use String values and
// the last character is used
// to create a range. Therefore
// the last character must be valid
// to create a range from.
def groovyRange = 'Groovy10'..&lt;'Groovy15'

assert groovyRange.from == 'Groovy10'
assert groovyRange.to == 'Groovy14'
assert groovyRange.toList() == ['Groovy10', 'Groovy11', 'Groovy12', 'Groovy13', 'Groovy14']


// Also works in reverse.
def groovyReverse = 'Groovy19'..'Groovy15'

assert groovyReverse.reverse
assert groovyReverse.from == 'Groovy15'
assert groovyReverse.to == 'Groovy19'
assert groovyReverse.toList() == ['Groovy19', 'Groovy18', 'Groovy17', 'Groovy16', 'Groovy15']


import static groovy.test.GroovyAssert.shouldFail

// Should fail because String values,
// except for the last character, should
// be the same.
shouldFail(IllegalArgumentException) {
    def invalidRange = 'Groovy15'..'Groovy20'
}
