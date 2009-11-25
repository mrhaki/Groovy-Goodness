// Different ways to create a new BigDecimal or BigInteger
assert 123g instanceof BigInteger
assert 42G instanceof BigInteger
assert 1.423 instanceof BigDecimal
assert 42.0g instanceof BigDecimal
assert 9203.10291G instanceof BigDecimal

// Let's do some math.
assert 3.2 == 1.2G + 2G
assert 10 == 10.1g - 0.1G
