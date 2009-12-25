def languages = ['Groovy', 'Clojure', 'Scala']

def sequences = languages.subsequences()

assert [['Clojure'], ['Scala'], ['Groovy']] == sequences.findAll { it.size() == 1 } as List
assert [['Clojure', 'Scala'], ['Groovy', 'Scala'], ['Groovy', 'Clojure']] == sequences.findAll { it.size() == 2 } as List
assert [['Groovy', 'Clojure', 'Scala']] == sequences.findAll { it.size() == 3}.toList()
