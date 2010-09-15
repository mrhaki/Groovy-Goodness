def one = ['Java', 'Groovy', 'Scala']
def two = ['Groovy', 'JRuby', 'Java']
def three = ['C++', 'C##']

assert ['Groovy', 'Java'] == one.intersect(two)
assert [] == one.intersect(three)
assert one.disjoint(three)
assert !one.disjoint(two)
