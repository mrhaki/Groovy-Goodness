def numbers = [1,2,1,4,1,2] as int[]
assert numbers.toSet() == [1,2,4] as Set

def list = ['Groovy', 'Java', 'Grails', 'Groovy']
assert list.toSet() == ['Groovy', 'Java', 'Grails'] as Set
