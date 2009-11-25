try {
    def url = new URL('malformedUrl')
    assert false, 'We should never get here because of the exception.'
} catch (MalformedURLException e) {
    assert true
    assert e in MalformedURLException
}

// Method throws MalformedURLException, but we don't 
// have to define it. Groovy will pass the exception
// on to the calling code.
def createUrl() {
    new URL('malformedUrl')
}

try {
    def url1 = createUrl()
    assert false, 'We should never get here because of the exception.'
} catch (all) {  // Groovy shortcut: we can omit the Exception class 
                 // if we want to catch all Exception and descendant objects. 
                 // In Java we have to write catch (Exception all).
    assert true
    assert all in MalformedURLException
}
