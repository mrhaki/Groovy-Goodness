def simple() {
    "Hello world"
}
assert 'Hello world' == simple()


def doIt(b) {
    if (b) {
        "You are true"
    } else {
        "You are false"
    }
}
assert 'You are true' == doIt(true)
assert 'You are false' == doIt(false)


def tryIt(file) {
    try {
        new File(file).text
    } catch (e) {
        "Received exception: ${e.message}"
    } finally {
        println 'Finally is executed but nothing is returned.'
        'Finally reached'
    }
}
assert 'Received exception: invalidfilename (The system cannot find the file specified)'  == tryIt('invalidfilename') 
// Create new file with the name test.
def newFile = new FileWriter('test').withWriter { it.write('file contents') }
assert 'file contents' == tryIt('test')
