def s = 'Accessing Strings in Groovy is easy.'

assert 'A' == s[0]
assert 'A' == s.getAt(0)
assert 'Groovy' == s[21..26]  // We can use ranges.
assert 'easy.' == s[s.indexOf('ea')..-1]

// We can also use each method on a String.
s[21..26].each { println "$it-" } // Output: G-r-o-o-v-y-
