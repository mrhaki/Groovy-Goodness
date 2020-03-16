def answer = new Integer(42)
def anotherAnswer = new Integer(42)
def meaningOfLife = answer

// Equals is true for answer and anotherAnswer
assert answer == anotherAnswer

// But they don't refer to the same instance.
assert answer !== anotherAnswer

// The variables meaningOfLife and answer
// do refer to the same object instance.
assert answer === meaningOfLife
