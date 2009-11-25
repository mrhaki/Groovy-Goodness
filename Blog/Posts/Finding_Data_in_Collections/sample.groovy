def list = ['Daffy', 'Bugs', 'Elmer', 'Tweety', 'Silvester', 'Yosemite']
assert 'Bugs' == list.find { it == 'Bugs' }
assert ['Daffy', 'Bugs', 'Elmer'] == list.findAll { it.size() < 6 }
assert 1 == list.findIndexOf { name -> name =~ /^B.*/ }  // Start with B.
assert 3 == list.findIndexOf(3) { it[0] > 'S' }  // Use a start index.
assert [0,3,5] == list.findIndexValues { it =~ /(y|Y)/ }  // Contains y or Y.
assert [3,5] == list.findIndexValues(2) { it =~ /(y|Y)/ }
assert 2 == list.findLastIndexOf { it.size() == 5 }
assert 5 == list.findLastIndexOf(1) { it.count('e') > 1 }
assert list.any { it =~ /a/ }
assert list.every { it.size() > 3 }

def map = [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com', blog: true]
def found = map.find { key, value -> key == 'name' }
assert found.key == 'name' && found.value == 'Messages from mrhaki'
found = map.find { it.value =~ /mrhaki/ }
assert found.key == 'name' && found.value == 'Messages from mrhaki'
assert [name: 'Messages from mrhaki', url: 'http://mrhaki.blogspot.com'] == map.findAll { key, value -> value =~ /mrhaki/ }
assert 1 == map.findIndexOf { it.value.endsWith('com') }
assert [1,2] == map.findIndexValues { it.key =~ /l/ }  // All keys with the letter 'l'.
assert 2 == map.findLastIndexOf { it.key =~ /l/ && it.value }
assert map.any { entry -> entry.value }
assert map.every { key, value -> key.size() >= 3 }
