// Closure simple increments parameter.
// Also script variable incrementChange is 
// changed so we can check if the result is
// from a cached call or not.
def incrementChange = false
def increment = { 
    incrementChange = true
    it + 1 
}
// Just invoke the closure 5 times with different parameters.
(0..5).each {
    incrementChange  = false
    assert increment(it) == it + 1
    assert incrementChange
}
incrementChange = false
assert increment(1) == 2  // Call is not cached.
assert incrementChange  

// Use memoize() so all calls are cached.
incrementChange = false
def incrementMemoize = increment.memoize()
// Just invoke the closure 5 times with different parameters.
(0..5).each {
    incrementChange = false
    assert incrementMemoize(it) == it + 1
    assert incrementChange
}
incrementChange = false
assert incrementMemoize(2) == 3  // Cached call.
assert !incrementChange  

// Use memoizeAtMost().
incrementChange = false
def memoizeAtMostOnce = increment.memoizeAtMost(1)
// Just invoke the closure 5 times with different parameters.
(0..5).each {
    incrementChange = false
    assert memoizeAtMostOnce(it) == it + 1
    assert incrementChange
}
incrementChange = false
assert memoizeAtMostOnce(1) == 2  // 2nd call is not cached.
assert incrementChange  
