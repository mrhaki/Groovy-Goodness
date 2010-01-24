def doubleValue = 12.5456d

assert 12.546d == doubleValue.round(3)
assert 13 == doubleValue.round()

assert 12 == doubleValue.trunc()
assert 12.54d == doubleValue.trunc(2)

def floatValue = 987.654f

assert 987.65f == floatValue.round(2)
assert 988 == floatValue.round()
assert 987.6f == floatValue.trunc(1)
assert 987 == floatValue.trunc()
