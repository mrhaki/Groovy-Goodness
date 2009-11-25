class Sample {
    String username
    String email
    List<String> labels = []
    def speakUp() { "I am $username" }
    def addLabel(value) { labels << value }
}

def sample = new Sample()
sample.with {
    username = 'mrhaki'
    email = 'email@host.com'
    println speakUp()  // Output: I am mrhaki
    addLabel 'Groovy' 
    addLabel 'Java'    
}
assert 2 == sample.labels.size()
assert 'Groovy' == sample.labels[0]
assert 'Java' == sample.labels[1]
assert 'mrhaki' == sample.username
assert 'email@host.com' == sample.email

def sb = new StringBuilder()
sb.with {
    append 'Just another way to add '
    append 'strings to the StringBuilder '
    append 'object.'    
}

assert 'Just another way to add strings to the StringBuilder object.' == sb.toString()

// Another example as seen at 
// http://javajeff.blogspot.com/2008/11/getting-groovy-with-with.html
def cal = Calendar.instance
cal.with {
    clear()
    set(YEAR, 2009)
    set MONTH, SEPTEMBER
    set DATE, 4    
    add DATE, 2
}
assert'September 6, 2009' == cal.time.format('MMMM d, yyyy')
