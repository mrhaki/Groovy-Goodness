def list = ['Groovy', 'Grails', 'Java']
assert list.count { it.startsWith('G') } == 2

def numbers = [1,2,3,4] as Integer[]
assert numbers.count { it > 2 } == 2

def map = [user: 'mrhaki', city: 'Tilburg', age: 37]
assert map.count { key, value -> key.size() == 3 } == 1
