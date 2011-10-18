def set1 = ['Java', 42, true] as Set
def set2 = ['Groovy', 42, true, 'Java'] as Set
def set3 = [42L, true, 'Java'] as Set

assert set1.equals(set3)
assert set1 == set3
assert !set1.equals(set2)
assert set2 != set3
