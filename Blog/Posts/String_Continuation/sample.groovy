def name ='mrhaki'

def s = "This is not a multiline\
 String, $name, but the continuation\
 character (\\) makes it more readable."
        
assert 'This is not a multiline String, mrhaki, but the continuation character (\\) makes it more readable.' == s
