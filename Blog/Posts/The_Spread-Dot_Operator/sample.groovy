class Language {
    String lang
    def speak() { "$lang speaks." }
}

// Create a list with 3 objects. Each object has a lang 
// property and a speak() method. 
def list = [     
    new Language(lang: 'Groovy'),     
    new Language(lang: 'Java'),     
    new Language(lang: 'Scala') 
]  

// Use the spread-dot operator to invoke the speak() method. 
assert ['Groovy speaks.', 'Java speaks.', 'Scala speaks.'] == list*.speak() 
assert ['Groovy speaks.', 'Java speaks.', 'Scala speaks.'] == list.collect{ it.speak() }  

// We can also use the spread-dot operator to access 
// properties, but we don't need to, because Groovy allows 
// direct property access on list members. 
assert ['Groovy', 'Java', 'Scala'] == list*.lang 
assert ['Groovy', 'Java', 'Scala'] == list.lang
