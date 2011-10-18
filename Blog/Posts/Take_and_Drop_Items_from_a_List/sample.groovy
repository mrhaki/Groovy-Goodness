def list = ['Simple', 'list', 'with', 5, 'items']

assert list.take(1) == ['Simple']
assert list.take(2) == ['Simple', 'list']
assert list.take(0) == []
// Whole list, because we take more items then the size of list
assert list.take(6) == ['Simple', 'list', 'with', 5, 'items']

assert list.drop(1) == ['list', 'with', 5, 'items']
assert list.drop(3) == [5, 'items']
assert list.drop(5) == []
assert list.drop(0) == ['Simple', 'list', 'with', 5, 'items']
assert list == ['Simple', 'list', 'with', 5, 'items']

// After reading Tim Yates' comment I have added 
// more samples showing drop() and take() also work on
// Maps, Iterators, CharSequences and arrays.
def array = ['Rock on!', 'Groovy baby!'] as String[]
assert array.take(1) == ['Rock on!'] as String[]
assert array.drop(1) == ['Groovy baby!'] as String[]

def range = 0..10
assert range.take(2) == [0,1]
assert range.take(4) == 0..3
assert range.drop(5) == 5..10

def map = [1: 'one', 2: 'two', 3: 'three']
assert map.take(2) == [1: 'one', 2: 'two']
assert map.drop(2) == [3: 'three']
assert map.drop(3) == [:]

def s = 'Hello Groovy world!'
assert s.take(5) == 'Hello'
assert s.drop(6) == 'Groovy world!'
