// Groovy 3 supports Java's lambda syntax expressions.
def inc = n -&gt; n + 1

assert inc(1) == 2


// But also adds default parameter values.
def multiplyBy = (n, factor = 2) -&gt; n * factor

assert multiplyBy(1) == 2
assert multiplyBy(1, 10) == 10
