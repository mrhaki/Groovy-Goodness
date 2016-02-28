def list = ['Simple', 'list', 'with', 5, 'items']

assert list.takeRight(1) == ['items']
assert list.takeRight(2) == [5, 'items']
assert list.takeRight(0) == []
// Whole list, because we take more items then the size of list
assert list.takeRight(6) == ['Simple', 'list', 'with', 5, 'items']

assert list.dropRight(1) == ['Simple', 'list', 'with', 5]
assert list.dropRight(3) == ['Simple', 'list']
assert list.dropRight(5) == []
assert list.dropRight(0) == ['Simple', 'list', 'with', 5, 'items']
assert list == ['Simple', 'list', 'with', 5, 'items']

def array = ['Rock on!', 'Groovy baby!'] as String[]
assert array.takeRight(1) == ['Groovy baby!'] as String[]
assert array.dropRight(1) == ['Rock on!'] as String[]

def range = 0..10
assert range.takeRight(2) == [9,10]
assert range.takeRight(4) == 7..10
assert range.dropRight(5) == 0..5
