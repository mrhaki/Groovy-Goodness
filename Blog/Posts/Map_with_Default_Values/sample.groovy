def m = [start: 'one'].withDefault { key -> 
    key.isNumber() ? 42 : 'Groovy rocks!'
}

assert 'one' == m.start
assert 42 == m['1']
assert 'Groovy rocks!' == m['I say']
assert 3 == m.size()

// We can still assign our own values to keys of course:
m['mrhaki'] = 'Hubert Klein Ikkink'
assert 'Hubert Klein Ikkink' == m.mrhaki
assert 4 == m.size()
