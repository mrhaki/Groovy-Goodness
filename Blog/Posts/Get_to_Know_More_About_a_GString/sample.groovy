
def user = 'mrhaki'
def language = 'Groovy'

def s = "Hello ${user}, welcome to ${language}."

assert 2 == s.valueCount
assert ['mrhaki', 'Groovy'] == s.values
assert 'mrhaki' == s.getValue(0)
assert 'Groovy' == s.getValue(1)
assert 32 == s.length()
assert 'Hello ' == s.strings[0]
assert ', welcome to ' == s.strings[1]
assert '.' == s.strings[2]
assert 'Hello mrhaki, welcome to Groovy.' == s
