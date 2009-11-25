def map = [name: 'mrhaki', country: 'The Netherlands', blog: true, languages: ['Groovy', 'Java']]

def keys = ['name', 'blog']
assert [name: 'mrhaki', blog: true] == map.subMap(keys)

def booleanKeys = map.findAll { it.value instanceof Boolean }.collect { it.key } 
assert [blog: true] == map.subMap(booleanKeys)

def words = ['a': 'Apple', 'j': 'Java', 'g': 'Groovy', 'c': 'Cool']
def range = 'c'..'h'  // Range is also a list and can be used here.
def rangeWords = words.subMap(range).findAll{ it.value }
// words.subMap(range) returns [c:Cool, d:null, e:null, f:null, g:Groovy, h:null]
// so we use the findAll method to filter out all null values.
assert ['c': 'Cool', 'g': 'Groovy'] == rangeWords
