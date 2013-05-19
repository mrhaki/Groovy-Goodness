def letters = 'a'..'g'

assert letters.collate(3) == [['a', 'b', 'c'], ['d', 'e', 'f'], ['g']]

// Step through original list with 
// 2 steps and collate.
assert letters.collate(3, 2) == [['a', 'b', 'c'], ['c', 'd', 'e'], ['e', 'f', 'g'], ['g']]

// Don't include remainder in result.
// Default a remainder is included in the result.
boolean remainder = false
assert letters.collate(3, remainder) == [['a', 'b', 'c'], ['d', 'e', 'f']]
assert letters.collate(3, 2, remainder) == [['a', 'b', 'c'], ['c', 'd', 'e'], ['e', 'f', 'g']]
