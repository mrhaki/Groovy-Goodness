def list = [1, [2, 3], [[4]]]

// Simple flatten the nested collections.
assert list.flatten() == [1, 2, 3, 4]

// We can use a closure to transform
// the elements in the resulting collection.
assert list.flatten { it * 2 } == [2, 4, 6, 8]
