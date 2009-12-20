def sizeList = { list, counter = 0 ->
    if (list.size() == 0) {
        counter
    } else {
        doCall(list.tail(), counter + 1)  // Call closure self.
    }
}

assert 5 == sizeList([1,2,3,4,5])
