// Counter is implementation for Iterable interface.
class Counter implements Iterable {
    Integer maxValue
    private Integer counter = 0
    
    // Return new Iterator instance.
    @Override
    Iterator iterator() {
        [hasNext: { counter <= maxValue }, 
         next: { counter++ }] as Iterator
    }
    
}

assert counter.sum() == 55
assert counter.min() == 0
assert counter.max() == 10
assert counter.count(2) == 1
assert counter.count { it % 2 == 0 } == 6
assert counter.collectMany { [it * 2] } == [0,2,4,6,8,10,12,14,16,18,20]
assert counter.groupBy { it % 4 == 0 ? 'fours' : 'noneFours' } == [fours: [0,4,8], noneFours: [1,2,3,5,6,7,9,10]]

private getCounter() {
    new Counter(maxValue: 10)
}
