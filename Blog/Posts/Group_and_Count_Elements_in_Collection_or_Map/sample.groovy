def list = ['Groovy', 'Grails', 'Java']
assert list.countBy { it[0] } == ['G': 2, 'J': 1]  // 2 items start with G, 1 with J.

def numbers = [1,2,3,4,5] as Integer[]
assert numbers.countBy { it % 2 } == [0: 2, 1: 3]  // 2 even, 3 uneven numbers

def map = [user: 'mrhaki', city: 'Tilburg', age: 37]
assert map.countBy { key, value -> value.class } == [(String.class): 2, (Integer.class): 1]  // 2 values of type String and 1 of type Integer
