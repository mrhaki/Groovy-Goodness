def list = [10, 20, 30, [1, 2, 3, [25, 50]], ['Groovy']]

assert [20, 40, 60, [2, 4, 6, [50, 100]], ['GroovyGroovy']] == list.collectAll { it*2 }
assert [20, 40, 60, [1, 2, 3, [25, 50], 1, 2, 3, [25, 50]], ['Groovy', 'Groovy']] == list.collect { it * 2 }
?
