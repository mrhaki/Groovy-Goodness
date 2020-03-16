def stuff = ['Groovy', 'Gradle', 'Grails', 'Spock', 'Micronaut', 'Ratpack'] as Set
def micro = ['Ratpack', 'Micronaut', 'SpringBoot', 'Microservice']

// Using default comparator to get values
// that are in both collections.
assert stuff.intersect(micro) == ['Ratpack', 'Micronaut'] as Set
assert micro.intersect(stuff) == ['Micronaut', 'Ratpack']

// Comparator to check if value is in
// both collection and starts with a 'M'.
def microName = { a, b -&gt; 
    def comp = a &lt;=&gt; b
    comp == 0 ? a[0] == 'M' ? 0 : -1 : comp
} as Comparator

// This time we use the Comparator and
// end up with all elements in both
// collections that start with a 'M'.
assert stuff.intersect(micro, microName) == ['Micronaut'] as Set
assert micro.intersect(stuff, microName) == ['Micronaut']
