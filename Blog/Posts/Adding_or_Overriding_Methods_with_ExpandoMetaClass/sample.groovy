Integer.metaClass.eights &lt;&lt; { delegate * 8 }
assert 32 == 4.eights()

Integer.metaClass.hundreds = { delegate * 100 }
assert 200 == 2.hundreds()

try {
    Integer.metaClass.toString &lt;&lt; { 'Groovy' } // Cannot use &lt;&lt; for existing method.
    assert false
} catch (e) {
    assert 'Cannot add new method [toString] for arguments [[]]. It already exists!' == e.message
}

Integer.metaClass.toString = { 'Groovy' }
assert 'Groovy' == 100.toString()
