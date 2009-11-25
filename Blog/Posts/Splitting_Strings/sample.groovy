def s = '''\
username;language,like
mrhaki,Groovy;yes
'''

assert s.split() instanceof String[]
assert ['username;language,like', 'mrhaki,Groovy;yes'] == s.split()  // Default split on whitespace. ( \t\n\r\f)
assert ['username', 'language', 'like', 'mrhaki', 'Groovy', 'yes'] == s.split(/(;|,|\n)/)  // Split argument is a regular expression.

def result = []
s.splitEachLine(",") {
    result << it  // it is list with result of split on ,
}
assert ['username;language', 'like'] == result[0]
assert ['mrhaki', 'Groovy;yes'] == result[1]

assert s.tokenize() instanceof List
assert ['username;language,like', 'mrhaki,Groovy;yes'] == s.tokenize()  // Default tokenize on whitespace. ( \t\n\r\f)
assert ['username', 'language', 'like', 'mrhaki', 'Groovy', 'yes'] == s.tokenize("\n;,")  // Argument is a String with all tokens we want to tokenize on.
