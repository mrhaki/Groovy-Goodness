def list = ['Groovy', 3, 'is', 'awesome', '!']

// New Groovy 3 syntax to check item 
// is NOT in a collection.
assert 'Java' !in list

// Old syntax.
assert !('Java' in list)

// Just to show in still works.
assert 'Groovy' in list
