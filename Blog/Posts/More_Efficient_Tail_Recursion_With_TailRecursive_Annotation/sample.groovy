import groovy.transform.TailRecursive

@TailRecursive
long sizeOfList(list, counter = 0) {
    if (list.size() == 0) {
        counter
    } else {
       sizeOfList(list.tail(), counter + 1) 
    }
}

// Without @TailRecursive a StackOverFlowError
// is thrown.
assert sizeOfList(1..10000) == 10000
