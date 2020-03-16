def calculate(String key, Integer... values) {
    // Method return a Tuple2 instance.
    new Tuple2(key, values.sum())
}

// Use multiple assignment to
// extract the values from the tuple.
// Tuple2 has typed objects.
def (String a, Integer b) = calculate('sum', 1, 2, 3)

assert a == 'sum'
assert b == 6
