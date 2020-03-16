// Define range with int values.
def ints = 1..10

assert ints.from == 1
assert ints.to == 10
assert ints == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
assert ints.class.name == 'groovy.lang.IntRange'

// Use by method to set steps
// between int values in range.
// The results is a new range.
def intsBy = ints.by(3)

assert intsBy.from == 1
assert intsBy.to == 10
assert intsBy == [1, 4, 7, 10]
assert intsBy.class.name == 'groovy.lang.NumberRange'

// Use step method to set steps
// between int values in range.
// The range is now converted to a List.
def intsStep = ints.step(3)

assert intsStep == [1, 4, 7, 10]
assert intsStep.class.name == 'java.util.ArrayList'

// Use by method to set step size to 0.9.
def intsBy2 = ints.by(0.9)

assert intsBy2.from == 1
assert intsBy2.to == 10
assert intsBy2 == [1, 1.9, 2.8, 3.7, 4.6, 5.5, 6.4, 7.3, 8.2, 9.1, 10.0]
assert intsBy2.class.name == 'groovy.lang.NumberRange'


// Define range with BigDecimal numbers.
def numbers = 1.0..4.5

assert numbers.from == 1.0
assert numbers.to == 4.5
assert numbers == [1.0, 2.0, 3.0, 4.0]
assert numbers.class.name == 'groovy.lang.NumberRange'

// Use by method to set step size
// between numbers to 0.5.
def numbersBy = numbers.by(0.5)

assert numbersBy.from == 1.0
assert numbersBy.to == 4.5
assert numbersBy == [1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]
assert numbersBy.class.name == 'groovy.lang.NumberRange'

// We cannot use the step method to set
// step size to 0.5,
// because the step method only accepts
// int values as argument.
try {
    numbers.step(0.5)
} catch (MissingMethodException e) {
    assert e.message.contains('Possible solutions: step(int), step(int, groovy.lang.Closure)')
}
