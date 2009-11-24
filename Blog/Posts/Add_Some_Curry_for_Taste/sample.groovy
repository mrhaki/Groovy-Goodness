// Simple sample.
def addNumbers = { x, y -> x + y }
def addOne = addNumbers.curry(1)
assert 5 == addOne(4)


// General closure to use a filter on a list.
def filterList = { filter, list -> list.findAll(filter) }
// Closure to find even numbers.
def even = { it % 2 == 0 }
// Closure to find odd numbers.  
def odd = { !even(it) }  
// Other closures can be curry parameters.
def evenFilterList = filterList.curry(even)
def oddFilterList = filterList.curry(odd)
assert [0,2,4,6,8] == evenFilterList(0..8)
assert [1,3,5,7] == oddFilterList(0..8)


// Recipe to find text in lines.
def findText = { filter, handler, text -> 
    text.eachLine {
        filter(it) ? handler(it) : null
    }
}
// Recipe for a regular expression filter.
def regexFilter = { pattern, line -> line =~ pattern }

// Create filter for searching lines with "Groovy".
def groovyFilter = regexFilter.curry(/Groovy/)
// Create handler to print out line.
def printHandler = { println "Found in line: $it" }

// Create specific closure as clone of processText to
// search with groovyFilter and print out found lines.
def findGroovy = findText.curry(groovyFilter, printHandler)

// Invoke the closure.
findGroovy('''Groovy rules!
And Java?
Well... Groovy needs the JVM... 
''')

// This will output:
// Found in line: Groovy rules!
// Found in line: Well... Groovy needs the JVM...
