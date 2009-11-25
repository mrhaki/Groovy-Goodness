def s = "Groovy is so much fun"
def methods = ['Upper', 'Lower']
def result = methods.collect { s."to${it}Case"() }
assert 'GROOVY IS SO MUCH FUN' == result[0]
assert 'groovy is so much fun' == result[1]

// We can pass parameters just like a normal method invocation.
def method = 'count'
def param = 'o'
assert 3 == s."$method"(param)  // s.count('o').
