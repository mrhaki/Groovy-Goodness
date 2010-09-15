def m1 = [a: 'Groovy', b: 'rocks', c: '!']
def m2 = [a: 'Groovy', b: 'rocks', c: '?', d: 'Yes!']

assert [a: 'Groovy', b: 'rocks'] == m1.intersect(m2)

assert [1: 1.0, 2: 2] == [1: 1.0, 2: 2].intersect([1: 1, 2: 2.0])
