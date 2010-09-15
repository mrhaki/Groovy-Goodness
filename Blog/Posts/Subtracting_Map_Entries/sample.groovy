def m1 = [user: 'mrhaki', age: 37]
def m2 = [user: 'mrhaki', name: 'Hubert']
def m3 = [user: 'Hubert', age: 37]

assert [age: 37] == m1 - m2
assert [user: 'mrhaki'] == m1 - m3
