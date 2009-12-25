def languages = ['Groovy', 'Clojure', 'Scala']

def result = []
languages.eachPermutation {
    result &lt;&lt; it
}

assert 6 == result.size()
assert ['Groovy', 'Clojure', 'Scala'] == result[0]
assert ['Groovy', 'Scala', 'Clojure'] == result[1]
assert [['Clojure', 'Groovy', 'Scala'], ['Clojure', 'Scala', 'Groovy']] == result.findAll { it[0] == 'Clojure' }

// We can also get the complete list of permutations as Set.
def list = [true, false]
def permutations = list.permutations()
assert 2 == permutations.size()
assert [[false,true], [true,false]] as Set == permutations
