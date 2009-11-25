// Booleans:
def b1 = false
def b2 = true
assert !b1
assert b2

// Strings:
def s1 = ''
def s2 = 'abc'
assert !s1
assert s2

// Numbers:
def n1 = 0
def n2 = 42
assert !n1
assert n2

// Lists, iterators:
def l1 = []
def l2 = [1, 3, 6]
assert !l1
assert l2
def i1 = l1.iterator()
def i2 = l2.iterator()
assert !i1
assert i2

// Maps:
def m1 = [:]
def m2 = ['key': 'value']
assert !m1
assert m2

// Objects:
def o1
def o2 = new Expando(name: 'groovy')
assert !o1
assert o2

// Matchers:
def ma1 = "groovy" =~ /java/
def ma2 = "groovy" =~ /groovy/
assert !ma1
assert ma2

