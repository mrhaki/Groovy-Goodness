class URLTest extends GroovyTestCase {
    void testNoProtocol() {
        // Test for exception.
        shouldFail {
            def url = new URL('')
        }

        // Test for exception and check resulting message.
        def msg = shouldFail {
            def url =  new URL('')
        }
        assert 'no protocol: ' == msg  // We can use the 'normal' assert.

        // Test for specific exception and resulting message.
        msg = shouldFail(MalformedURLException) {
            def url = new URL('')
        }
        assertEquals 'no protocol: ', msg  // We can use the JUnit assertEquals.

        // Test for exception higher up in the hierarchy.
        shouldFail(IOException) {
            def url = new URL('')
        }
    }
}
