def range = 1..10
def (even, odd) = range.split { it % 2 == 0 }
assert [2,4,6,8,10] == even
assert [1,3,5,7,9] == odd

def map = [language: 'Groovy', username: 'mrhaki', age: 36]
def (strings, others) = map.split { it.value instanceof String } 
assert 2 == strings.size()
assert 1 == others.size()
assert 'language' == strings[0].key &amp;&amp; 'Groovy' == strings[0].value 
assert 'username' == strings[1].key &amp;&amp; 'mrhaki' == strings[1].value 
assert 'age' == others[0].key &amp;&amp; 36 == others[0].value
