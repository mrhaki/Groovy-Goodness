def s = 'Groovy and Strings are fun and versatile.'

assert 'Groovy and Strings are fun' == s - ' and versatile.'
assert 'Groovy and Strings are fun.' == s.minus(" and versatile")
assert 'Groovy  Strings are fun and versatile.' == s - ~/\b\w{3}\b/
