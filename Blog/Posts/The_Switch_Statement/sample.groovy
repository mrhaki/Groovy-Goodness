def testSwitch(val) {
    def result
    switch (val) {
        case ~/^Switch.*Groovy$/:
            result = 'Pattern match'
            break
        case BigInteger:
            result = 'Class isInstance'
            break
        case 60..90:
            result = 'Range contains'
            break
        case [21, 'test', 9.12]:
            result = 'List contains'
            break
        case 42.056:
            result = 'Object equals'
            break
        case { it instanceof Integer && it < 50 }:
            result = 'Closure boolean'
            break
        default:
            result = 'Default'
            break
    }    
    result
}

assert 'Pattern match' == testSwitch("Switch to Groovy")
assert 'Class isInstance' == testSwitch(42G)
assert 'Range contains' == testSwitch(70)
assert 'List contains' == testSwitch('test')
assert 'Object equals' == testSwitch(42.056)
assert 'Closure boolean' == testSwitch(20)
assert 'Default' == testSwitch('default')
