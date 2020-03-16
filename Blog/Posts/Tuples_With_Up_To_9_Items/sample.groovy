// We can define the types of the elements when we 
// construct a tuple.
def tuple3 = new Tuple3&lt;String, Integer, BigDecimal&gt;('add', 2, 40.0)

// We can use first, second, third properties
// to get values from the tuple.
assert tuple3.first == 'add'
assert tuple3.second == 2
assert tuple3.third == 40.0

// We can use the [index] syntax to get element.
assert tuple3[0] == 'add'  

// Fully typed tuple.
Tuple4&lt;String, Integer, BigDecimal, Integer&gt; tuple4 = 
    new Tuple4&lt;&gt;('subtract', 100, 55.0, 3)
    
assert tuple4.first == 'subtract'
assert tuple4.second == 100
assert tuple4.third == 55.0
assert tuple4.fourth == 3
assert tuple4[-1] == 3

// With subTuple we can get subsequent
// values from the tuple as a new tuple.
assert tuple4.subTuple(2, tuple4.size()) == new Tuple2&lt;BigDecimal, Integer&gt;(55.0, 3)

// We can imagine how to work with Tuple4..Tuple8 :-)
// ...

// Finally a tuple with 9 items.
def tuple9 = new Tuple9('Groovy', 'rocks', 'and', 'is', 'fun', 'to', 'use', 'as', 'language')

assert tuple9.fifth == 'fun'
assert tuple9.sixth == 'to'
assert tuple9.seventh == 'use'
assert tuple9.eighth == 'as'
assert tuple9.ninth == 'language'

// Tuple extends AbstractList, so we can
// use all methods from List as well.
assert tuple9.join(' ') == 'Groovy rocks and is fun to use as language'
