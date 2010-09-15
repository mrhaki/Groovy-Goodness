def n = '42.01'
def i = '201'

assert n.isNumber() && n.isBigDecimal() && n.isFloat() && n.isDouble()
assert i.isInteger() && i.isLong() && i.isBigInteger()
