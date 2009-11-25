// Simple map.
def m = [name: 'mrhaki', language: 'Groovy']

assert 'mrhaki' == m.getAt('name')
assert 'mrhaki' == m['name']
assert 'Groovy' == m.language
assert 'mrhaki' == m."name"
assert 'mrhaki' == m.get('name')  // We can omit the default value if we know the key exists.
assert 'Groovy' == m.get('language', 'Java')
assert null == m.get('expression')  // Non-existing key in map.
assert 'rocks' == m.get('expression', 'rocks')  // Use default value, this also creates the key/value pair in the map.
assert 'rocks' ==  m.get('expression')
assert [name: 'mrhaki', language: 'Groovy', expression: 'rocks'] == m
