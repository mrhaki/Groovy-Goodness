def list = ['key', 'value', 'name', 'mrhaki'] as Object[]
def map = list.toSpreadMap()

assert 2 == map.size()
assert 'value' == map.key
assert 'mrhaki' == map['name']
