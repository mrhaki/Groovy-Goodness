def source = 'Read more about "Groovy" at http://mrhaki.blogspot.com/'

// 'Normal' slashy String, we need to escape / with \/
def regexp = /.*"(.*)".*\/(.*)\//  

def matcher = source =~ regexp
assert matcher[0][1] == 'Groovy'
assert matcher[0][2] == 'mrhaki.blogspot.com'

// Dollar slash String.
def regexpDollar = $/.*"(.*)".*/(.*)//$  

def matcherDollar = source =~ regexpDollar
assert matcher[0][1] == 'Groovy'
assert matcher[0][2] == 'mrhaki.blogspot.com'

def multiline = $/
Also multilines 
are supported.
/$
