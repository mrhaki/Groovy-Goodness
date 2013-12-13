import groovy.transform.*

// Script variable which is changed when increment()
// method is invoked. 
// If cached method call is invoked then the value
// of this variable will not change.
@Field boolean incrementChange = false

@Memoized 
int increment(int value) {
    incrementChange = true
    value + 1 
}

// Invoke increment with argument 10.
increment(10)

// increment is invoked so incrementChange is true.
assert incrementChange

// Set incrementChange back to false.
incrementChange = false

// Invoke increment with argument 10.
increment(10)

// Now the cached method is used and
// incrementChange is not changed.
assert !incrementChange

// Invoke increment with other argument value.
increment(11)

// increment is invoked so incrementChange is true.
assert incrementChange
