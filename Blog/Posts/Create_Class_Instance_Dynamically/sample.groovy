class Blog {
    String name
    String subject
    
    Blog() {}
    
    Blog(String name, String subject) {
        this.name = name
        this.subject = subject
    }
}

def blog = Blog.newInstance()
assert !blog.name, 'Name has no value'
assert !blog.subject, 'Subject has no value'

def blog2 = Blog.newInstance(['mrhaki', 'Groovy'] as Object[])
assert 'mrhaki' == blog2.name
assert 'Groovy' == blog2.subject

def blog3 = Blog.newInstance([name:'mrhaki', subject: 'Groovy'])
assert 'mrhaki' == blog3.name
assert 'Groovy' == blog3.subject
