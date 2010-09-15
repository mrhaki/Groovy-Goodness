def n = 0..5 as Integer[]

assert n instanceof Integer[]
assert      0 + 1 + 2 + 3 + 4 + 5 == n.sum()
assert 10 + 0 + 1 + 2 + 3 + 4 + 5 == n.sum(10)
assert      0 + 10 + 20 + 30 + 40 + 50 == n.sum { it * 10 }
assert 10 + 0 + 10 + 20 + 30 + 40 + 50 == n.sum(10, { it * 10 })
