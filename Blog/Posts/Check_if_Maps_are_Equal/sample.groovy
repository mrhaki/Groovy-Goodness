def map1 = [user: 'mrhaki', likes: 'Groovy', age: 37]
def map2 = [age: 37.0, likes: 'Groovy', user: 'mrhaki']
def map3 = [user: 'Hubert Klein Ikkink', likes: 'Groovy']

assert map1.equals(map2)
assert map1 == map2
assert !map1.equals(map3)
assert map2 != map3
