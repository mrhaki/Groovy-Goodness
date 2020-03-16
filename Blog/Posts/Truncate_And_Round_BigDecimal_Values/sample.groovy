def bigDecimal = 42.576135

// Groovy uses BigDecimal for decimal 
// numbers by default.
assert bigDecimal.class.name == 'java.math.BigDecimal'

assert bigDecimal.round() == 43
assert bigDecimal.round(2) == 42.58

assert bigDecimal.trunc() == 42
assert bigDecimal.trunc(2) == 42.57
