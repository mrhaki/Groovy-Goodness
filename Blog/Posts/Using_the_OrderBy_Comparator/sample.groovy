class Language {
    String name
    boolean dynamic
    String toString() { "name: $name, dynamic: $dynamic" }
}

def languages = [
    new Language(name: 'Groovy', dynamic: true),
    new Language(name: 'Java', dynamic: false),
    new Language(name: 'Clojure', dynamic: true)
]

// We order first on dynamic property and then name property.
def orderByDynamicAndName = new OrderBy([{ it.dynamic }, { it.name }])
def sortedLanguages = languages.sort(orderByDynamicAndName)

assert 'Java' == sortedLanguages[0].name
assert !sortedLanguages[0].dynamic
assert 'Clojure' == sortedLanguages[1].name 
assert 'Groovy' == sortedLanguages[2].name
assert sortedLanguages[1].dynamic && sortedLanguages[2].dynamic
