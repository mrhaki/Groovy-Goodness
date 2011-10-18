def words = ['Groovy', 'Rocks', 'Big', 'Time']

def result = words.collectEntries { 
    [(it): it.contains('o')]
}

assert result.Groovy &amp;&amp; result.Rocks
assert !result.Big &amp;&amp; !result.Time
