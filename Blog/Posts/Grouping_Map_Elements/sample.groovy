// A simple map.
def m = [q1: 'Groovy', sort: 'desc', q2: 'Grails']

// Closure we use to define the grouping.
// We want all keys starting with 'q' grouped together
// with the key 'params', all other keys are not grouped.
def groupIt = { key, value ->
    if (key.startsWith('q')) { 
        'params'
    } else {
        key
    }
}

// Use groupEntriesBy.
def groupEntries = m.groupEntriesBy(groupIt)
assert 2 == groupEntries.size()
assert groupEntries.params & groupEntries.sort
assert 'desc' == groupEntries.sort[0].value  // Key for a list of Map$Entry objects.
assert 2 == groupEntries.params.size()
assert 'Groovy' == groupEntries.params[0].value
assert 'q1' == groupEntries.params[0].key
assert 'Grails' == groupEntries.params.find { it.key == 'q2' }.value
assert groupEntries.params instanceof ArrayList
assert groupEntries.params[0] instanceof Map$Entry

// Use groupBy.
def group = m.groupBy(groupIt)
assert 2 == group.size()
assert group.params & group.sort
assert 'desc' == group.sort.sort  // Key for Map with key/value pairs.
assert 2 == group.params.size()
assert 'Groovy' == group.params.q1
assert 'q1' == group.params.keySet().toArray()[0]
assert 'Grails' == group.params.q2
assert group.params instanceof Map
assert group.params.q1 instanceof String
