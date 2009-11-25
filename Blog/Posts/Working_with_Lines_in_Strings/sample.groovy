def multiline = '''\
Groovy is closely related to Java,
so it is quite easy to make a transition.
'''

// eachLine takes a closure with one argument, that
// contains the complete line.
multiline.eachLine { 
    if (it =~ /Groovy/) {
        println it  // Output: Groovy is closely related to Java,
    }
}  

// or eachLine has a closure with two argument, the current line
// and the line count.
multiline.eachLine { line, count -> 
    if (count == 0) {
        println "line $count: $line"  // Output: line 0: Groovy is closely related to Java,
    }
}

def platformLinefeeds = multiline.denormalize()
def linefeeds = multiline.normalize()

// Read all lines and convert to list.
def list = multiline.readLines()
assert list instanceof ArrayList
assert 2 == list.size()
assert 'Groovy is closely related to Java,' == list[0]

def records = """\
mrhaki\tGroovy
hubert\tJava
"""

// splitEachLine will split each line with the specified
// separator. The closure has one argument, the list of 
// elements separated by the separator.
records.splitEachLine('\t') { items ->
    println items[0] + " likes " + items[1]
}
// Output:
// mrhaki likes Groovy
// hubert likes Java
