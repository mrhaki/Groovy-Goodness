String s = 'I am in local scope.'
def i = 42
counter = 0

def runIt() {
    try {
        assert 'I am in local scope.' == s
    } catch (e) {
        assert e instanceof MissingPropertyException
    }
    try {
        assert 42 == i
    } catch (e) {
        assert e instanceof MissingPropertyException
    }
    assert 0 == counter++
}

runIt()

assert 'I am in local scope.' == s
assert 42 == i
assert 1 == counter
