def convert = { new Expando(language: it) }
def upper = { it.toUpperCase() }

// Composition.
def upperConvert = convert << upper

def languages = ['Groovy', 'Scala', 'Clojure'].collect(upperConvert)
println languages // Output: [{language=GROOVY}, {language=SCALA}, {language=CLOJURE}]
assert languages[0].language == 'GROOVY'
assert languages[1].language == 'SCALA'
assert languages[2].language == 'CLOJURE'

// Reverse composition.
def lastLetter = { it[-1] }
def firstLetters = ['Groovy', 'Clojure', 'Scala'].collect(upper >> lastLetter)
assert firstLetters.join() == 'YEA'
