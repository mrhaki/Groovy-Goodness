def list = ['Groovy', 'Java', 'JRuby'].asImmutable()
assert 'Groovy' == list[0]
try {
    list << 'Scala'  // Cannot add item.
} catch (e) {
    assert e instanceof UnsupportedOperationException
}
try {
    list.remove 'Java'  // Cannot remove item.
} catch (e) {
    assert e instanceof UnsupportedOperationException
}

def map = [name: 'mrhaki', country: 'The Netherlands', blog: true].asImmutable()
assert map.blog
try {
    map.blog = false  // Cannot change item.
} catch (e) {
    assert e instanceof UnsupportedOperationException
}
