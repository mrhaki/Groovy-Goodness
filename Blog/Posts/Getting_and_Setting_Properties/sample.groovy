def s1 = new Simple()
s1.setMessage('Old style')
assert 'GET SET Old style' == s1.getMessage()
s1.setMessage 'A bit more Groovy'  // No parenthesis.
assert 'GET SET A bit more Groovy' == s1.getMessage()

def s2 = new Simple(message: 'Groovy constructor')  // Named parameter in constructor.
assert 'GET SET Groovy constructor' == s1.getMessage()

def s3 = new Simple()
s3.message = 'Groovy style'  // = assigment for property.
assert 'GET SET Groovy style' == s3.message  // get value with . notation.
