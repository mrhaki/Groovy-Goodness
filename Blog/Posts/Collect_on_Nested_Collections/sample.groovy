def list = [10, 20, [1, 2, [25, 50]], ['Groovy']]

assert list.collectNested { it * 2 } == [20, 40, [2, 4, [50, 100]], ['GroovyGroovy']]
assert list.collectNested(['1.8.1', [0]]) { it * 2 } == ['1.8.1', [0], 20, 40, [2, 4, [50, 100]], ['GroovyGroovy']]
assert list.collectNested([]) { it * 2 } == [20, 40, [2, 4, [50, 100]], ['GroovyGroovy']]

// Simple collect will duplicate the nested collection instead
// of elements in the nested collection.
assert list.collect { it * 2 } == [20, 40, [1, 2, [25, 50], 1, 2, [25, 50]], ['Groovy', 'Groovy']]
