class Shape { }
class Circle extends Shape { }
class Square extends Shape {}

// Create Square instance.
def square = new Square()

assert square in Shape
assert square in Square
assert !(square in Circle)

[Shape.class, Square.class].each {
    assert square in it
}
