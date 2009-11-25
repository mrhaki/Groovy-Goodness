Integer myInt = 42
Integer anotherInt = myInt
Integer newInt = 42
Integer different = 101

assert myInt == anotherInt  // In Java: myInt != null && myInt.equals(anotherInt)
assert myInt.is(anotherInt)  // In Java: myInt == anotherInt

assert myInt == newInt

assert myInt != different
