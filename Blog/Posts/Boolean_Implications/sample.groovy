def a = true
def b = true

assert a.implies(b)
assert !(a.implies(false))

assert a.implies(b) == ((!a).or(b))

assert true.implies(true)
assert false.implies(true)
assert false.implies(false)
assert !true.implies(false)
