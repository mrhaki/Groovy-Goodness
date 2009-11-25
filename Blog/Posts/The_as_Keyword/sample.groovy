import java.text.MessageFormat as mf // Alias mf

// Use alias and use as to convert list to Object[]:
assert 'Simple message!' == mf.format('Simple {0}!', ['message'] as Object[])

// Normal Groovy list:
def intList = [1,2,3,4]
assert 'java.util.ArrayList' == intList.class.name
assert 4 == intList.size()

// Coerse to int[]:
def intArray = intList as int[]
assert 'java.util.ArrayList' != intArray.class.name
assert 4 == intArray.length  // Use int[] property.

// Use as to create Date object from list:
def date = [109, 8, 6] as Date
assert 2009 == date[Calendar.YEAR]
assert 8 == date[Calendar.MONTH]
assert 6 == date[Calendar.DATE]

// Use as to treat closure as implementation for
// the Runnable interface:
def t = new Thread({ println 'hello' } as Runnable)
t.start()  // Output: hello

// Use as to treat map as implementation for
// the Runnable interface:
def t2 = new Thread([run: { println 'hello' }] as Runnable)
t2.start()  // Output: hello
