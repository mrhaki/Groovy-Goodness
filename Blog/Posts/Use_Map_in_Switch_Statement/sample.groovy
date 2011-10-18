def testSwitch(val) {
    def result
    switch (val) {
        // New in Groovy 1.7.6: Map support.
        case [groovy: 'Rocks!', version: '1.7.6']:
            result = "Map contains key '$val'"
            break
        case 60..90:
            result = "Range contains $val"
            break
        case [21, 'test', 9.12]:
            result = "List contains '$val'"
            break
        default:
            result = 'Default'
            break
    }    
    result
}

assert testSwitch('groovy') == "Map contains key 'groovy'"
assert testSwitch(70) == 'Range contains 70'
assert testSwitch('test') == "List contains 'test'"
assert testSwitch('default') == 'Default'
