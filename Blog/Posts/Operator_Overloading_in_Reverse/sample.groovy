def a = true
def b = false

assert a | b
// Java Boolean has no or method.
assert a.or(b) 

assert !(a &amp; b)
assert !(a.and(b))


def x = 100
def y = 10

assert x + y == 110
// Java Integer has no plus method.
assert x.plus(y) == 110 

assert ++x == 101  
// ++ maps to next method.
assert x.next() == 102

assert --y == 9
assert y.previous() == 8
