// Contents of http://www.mrhaki.com/url.html:
// Simple test document
// for testing URL extensions
// in Groovy.

def url = "http://www.mrhaki.com/url.html".toURL()

assert '''\
Simple test document
for testing URL extensions
in Groovy.
''' == url.text

def result = []
url.eachLine {
    if (it =~ /Groovy/) {
        result << it
    }
}
assert ['in Groovy.'] == result

url.withReader { reader ->
    assert 'Simple test document' == reader.readLine()
}
