def reversed = [:]
[a: 1, c: 3, b: 2].reverseEach { key, value ->
    reversed[key] = value ** 2
}

assert [b: 4, c: 9, a: 1] == reversed

// TreeMap uses natural ordering of keys, so 
// reverseEach starts with key 'c'.
def tree = [a: 10, c: 30, b: 20] as TreeMap
def reversedMap = [:]
tree.reverseEach {
    reversedMap[it.key] = it.value * 2
}
assert [c: 60, b: 40, a: 20] == reversedMap
