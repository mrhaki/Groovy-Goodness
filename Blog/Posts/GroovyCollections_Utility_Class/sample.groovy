def methods = ['min', 'max', 'sum']
def classes = ['Object[]', 'Collection']

def combinations = GroovyCollections.combinations([classes, methods])
assert 2 * 3 == combinations.size()
assert [['Object[]', 'min'], ['Collection', 'min'], ['Object[]', 'max'], ['Collection', 'max'], ['Object[]', 'sum'], ['Collection', 'sum']] == combinations
assert 3 == combinations.findAll { it[0] == 'Collection' }.size()

def keys = ['username', 'email']
def values = ['mrhaki', 'email@host.com', 'not-tranposed']
def transpose = GroovyCollections.transpose([keys, values, [0, 1]])
assert 2 == transpose.size()
assert [['username', 'mrhaki', 0], ['email', 'email@host.com', 1]] == transpose
