def key = 100  // Variable to be used a key.

def m = [
    (new Date(109, 11, 1)): 'date key', 
    (-42): 'negative number key', 
    (false): 'boolean key',
    (key): 'variable key'
]
m.(true) = 'boolean key'  // Key is converted to String.
m.(2 + 2) = 'number key'
m[(key + 1)] = 'number key'  // Key keeps to be Integer.

assert 'date key' == m[new Date(109, 11, 1)]
assert 'negative number key' == m.get(-42)
assert 'boolean key' == m[(false)]
assert 'variable key' == m[100]
assert 'variable key' == m.getAt(key)
assert 'boolean key' == m['true']  // Key is String so we can use it to get the value.
assert 'number key' == m.'4'
assert 'number key' == m.get(101)
