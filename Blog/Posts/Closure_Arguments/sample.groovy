// Closure with default 'it' argument.
def defaultIt = { it - 1 }
assert 'Groovy String with .' == defaultIt('Groovy String with 1.')
assert 41 == defaultIt(42)

// Closure with named argument.
def namedArg = { value -> value * 2 }
assert 'Groovy Groovy ' == namedArg('Groovy ')
assert 84 == namedArg(42)

// Closure with multiple named arguments.
def moreArgs = { a, b -> a + b }
assert 'Groovy Java' == moreArgs('Groovy ', 'Java')
assert 44 == moreArgs(42, 2)

// Closure without arguments, even no 'it'.
def noArgs = {-> 'Groovy closure without arguments' }
assert 'Groovy closure without arguments' == noArgs()
