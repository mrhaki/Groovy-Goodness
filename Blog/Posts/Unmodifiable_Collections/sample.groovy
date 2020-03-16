import static groovy.test.GroovyAssert.shouldFail

// Create List that is unmodifiable.
def list = ['Groovy', 'Gradle', 'Asciidoctor', 'Micronaut'].asUnmodifiable()

shouldFail(UnsupportedOperationException) {
    // We cannot add new items.
    list &lt;&lt; 'Java'
}
    
shouldFail(UnsupportedOperationException) {
    // We cannot change items.
    list[0] = 'Java'
}


// Create Map that is unmodifiable.
def data = [name: 'Messages from mrhaki', subject: 'Gr8 stuff'].asUnmodifiable()

shouldFail(UnsupportedOperationException) {
    // We cannot add a new key.
    data.subject = 'Dev subjects'
}
    
shouldFail(UnsupportedOperationException) {
    // We cannot change the value of a key.
    data.blog = true
}
