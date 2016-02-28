// Configuration script.
def config = '''
app {
    version = 0
    active = false
}
'''

// Read configuration.
def configuration = new ConfigSlurper().parse(config)

// Check values for app. configuration properties.
configuration.app.with {
    // Existing boolean property.
    // Is property value false or non-existing?
    assert !active
    // Answer: value is false.
    assert isSet('active')


    // Not existing boolean property.
    // Is property value false or non-existing?
    assert !enabled
    // Answer: non-existing.
    assert !isSet('enabled')


    // Non boolean property.
    assert !version
    assert isSet('version')
    assert version == 0
}
