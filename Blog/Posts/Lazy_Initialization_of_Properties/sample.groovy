class Get {
    String url
    @Lazy URL urlObj = { url?.toURL() }()  // Closures allowed to create object.
    // Will use a soft reference.
    @Lazy(soft=true) String text = urlObj?.text
}

def g = new Get(url: 'http://mrhaki.blogspot.com/') 
assert 'http://mrhaki.blogspot.com/' == g.url
assert g.dump().contains('text=null')
assert g.dump().contains('urlObj=null')

// Now we access the urlObj property, so the value
// is calculated and we can access it.
assert g.urlObj
assert 'http' == g.urlObj.protocol
assert 'mrhaki.blogspot.com' == g.urlObj.host
assert '/' == g.urlObj.path

// Now we access the text property, so the contents
// is fetched from the URL.
assert g.text
assert g.text.contains('Messages from mrhaki')
