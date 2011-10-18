// Contents of http://www.mrhaki.com/url.html:
// Simple test document
// for testing URL extensions
// in Groovy.

def url = "http://www.mrhaki.com/url.html".toURL()

// Simple Integer enhancement to make
// 10.seconds be 10 * 1000 ms.
Integer.metaClass.getSeconds = { -&gt;
    delegate * 1000
}

// Get content of URL with parameters.
def content = url.getText(connectTimeout: 10.seconds, readTimeout: 10.seconds,
                          useCaches: true, allowUserInteraction: false,
                          requestProperties: ['User-Agent': 'Groovy Sample Script'])

assert content == '''\
Simple test document
for testing URL extensions
in Groovy.
'''

url.newReader(connectTimeout: 10.seconds, useCaches: true).withReader { reader -&gt;
    assert reader.readLine() == 'Simple test document'
}
