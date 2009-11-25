// Simple ranges with number values.
def ints = 1..10
assert [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] == ints
assert 10 == ints.size()
assert 1  == ints.from
assert 10 == ints.to

// We can step through the values.
def list = []
ints.step(2) { list << it }
assert [1, 3, 5, 7, 9] == list

// A range is just a List.
assert 1  == ints[0]
assert 10 == ints.last()
def s = ''
(2..4).each { s += it }
assert '234' == s

// Exclusive range.
def exclusive = 2..<8
assert [2, 3, 4, 5, 6, 7] == exclusive
assert 6 == exclusive.size()
assert !exclusive.contains(8)

// Object with next() and previous() can be used
// in ranges. Groovy extends Java enum with 
// next() and previous() so we can use it in ranges.
enum Compass {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST, 
    SOUTH, SOUTH_WEST, WEST, NORTH_WEST
}
def northToSouth = Compass.NORTH..Compass.SOUTH
assert 5 == northToSouth.size()
assert Compass.EAST == northToSouth[2]
assert northToSouth.contains(Compass.SOUTH_EAST)

// Bonus: next() and previous() are equivalent to 
// ++ and -- operators.
def region = Compass.SOUTH
assert Compass.SOUTH_WEST == ++region
assert Compass.SOUTH == --region
