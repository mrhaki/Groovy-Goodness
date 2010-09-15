// Collect without 
// initial collection.
assert [0,2,4,6] == (0..3).collect { it * 2 }
assert ['Groovy', 'Grails'] == [lang: 'Groovy', framework: 'Grails'].collect { it.value }

// Collect with initial collection argument.
assert [0, 1, 2, 3] == [2, 3].collect([0, 1]) { it }
assert [0, 3, 6, 9] == [2, 3].collect([0, 3], { it * 3})
assert ['Gradle', 'groovy', 'grails'] == ['Groovy', 'Grails'].collect(['Gradle']) { it.toLowerCase() }
assert ['m','r','h','a','k','i'] == [4, -3, 7, 5].collect(['m', 'r']) { (it + 100) as char }
