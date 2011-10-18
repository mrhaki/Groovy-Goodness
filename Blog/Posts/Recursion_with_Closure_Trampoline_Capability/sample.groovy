def sizeList
sizeList = { list, counter = 0 ->
    if (list.size() == 0) {
        counter
    } else {
        sizeList.trampoline(list.tail(), counter + 1)
    }
}
sizeList = sizeList.trampoline()

assert sizeList(1..10000) == 10000
