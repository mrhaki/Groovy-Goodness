class StringConverter {
    def value
    
    def value(s) {
        value = s
        this
    }

    /** Convert characters in value property if cond is true */    
    def upper(cond) {
        value = value.collect { cond(it) ? it.toUpperCase() : it }.join()
    }

    def call(callable) {
        callable
    }
}

def converter = new StringConverter()
converter.with {
    value 'mrhaki' upper { it &lt; 'm' }
    // Equivalent to:
    // value('mrhaki') upper { it &lt; 'm' }
    // or
    // value('mrhaki').call(upper { it &lt; 'm' })
    // or
    // value('mrhaki').call(upper({ it &lt; 'm' }))
}
assert converter.value == 'mrHAKI'

converter.with {
    value('jdriven') upper { it == 'j' || it == 'd' }

    assert value == 'JDriven'
}
