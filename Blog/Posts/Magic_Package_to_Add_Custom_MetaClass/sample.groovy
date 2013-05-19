// File: StringDelegateSample.groovy

// Original methods are still invoked.
assert 'mrhaki'.toUpperCase() == 'MRHAKI'

// Invoke 'hasGroovy' method we added via the DelegatingMetaClass.
assert !'Java'.hasGroovy()
assert 'mrhaki loves Groovy'.hasGroovy()
assert 'Groovy'.toLowerCase().hasGroovy()
