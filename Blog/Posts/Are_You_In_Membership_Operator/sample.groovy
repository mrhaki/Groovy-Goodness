// *** Conditional context for membership operator.
def list = ['Groovy', 'Java']
assert 'Groovy' in list
assert !('Scala' in list)

// Write our own in implementation.
class MyObject {
    String value
    boolean isCase(ch) { 
        value.contains(ch) 
    }
}
def myObj = new MyObject(value: 'Groovy')
assert 'oo' in myObj
assert !('oo' in myObj.value)  // isCase for String invokes equals.
assert 'Groovy' in myObj
assert 'Groovy' in myObj.value
assert !('a' in myObj)

// *** Iterative context
// Use in in a for loop.
def result = ''
for (lang in list ) {
    result += lang
}
assert 'GroovyJava' == result

class Counter {
    Integer maxValue
    private Integer counter = 0
    Iterator iterator() {
        [hasNext: { counter <= maxValue }, 
         next: { counter++ }] as Iterator
    }
}
def counter = new Counter(maxValue: 10)
result = '' 
for (c in counter) {
    result += c
}
assert result == '012345678910'