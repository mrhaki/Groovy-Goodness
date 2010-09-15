def list = ['Groovy', 'Grails', 'Griffon', 'Gradle']
def iterator = list.iterator()

assert 'Groovy' == iterator[0]
assert 'Gradle' == iterator[-1]
assert !iterator[1]  // Iterator is exhausted.

iterator = list.iterator()  // Get new iterator.
def newList = []
(0..&lt;list.size()).each {
 newList &lt;&lt; iterator[0]  // Index 0 is next element.
}
assert 'Groovy,Grails,Griffon,Gradle' == newList.join(',')
