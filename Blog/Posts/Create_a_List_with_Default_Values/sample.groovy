def lazy = ['abc', 42].withDefault { 'default' } // Or .withLazyDefault {}

// List grows because 3 is bigger than
// current lazy list size. Value is
// for element at index 3 is set with value
// from init closure.
assert lazy[3] == 'default'

// Gap at index 2 is filled with null value.
assert lazy == ['abc', 42, null, 'default']

// Because value at index 2 is set to null
// before, the init closure is invoked
// for this index now.
assert lazy[2] == 'default'

// List is now filled.
assert lazy == ['abc', 42, 'default', 'default']


def eager = ['abc', 42].withEagerDefault { 'default' }

// Here the list also grows, because
// index 3 is bigger than eager list size.
assert eager[3] == 'default'

// The gaps in the list are now
// filled with the value from
// the init closure.
assert eager == ['abc', 42, 'default', 'default']

// Value is already set because we
// used withEagerDefault.
assert eager[2] == 'default'


// We can use the index value as argument
// for the init closure.
def sample = [1,2,3].withDefault { index ->
    index % 2
}

assert sample[3] == 1
assert sample[4] == 0
