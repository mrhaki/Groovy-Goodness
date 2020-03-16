// First an example using the elvis operator.
a = null
a = a ?: 100

assert a == 100

// Now we can shorten the assignment using the 
// elvis assignment operator.
a = null
a ?= 100

assert a == 100

b = 200
b ?= 100

assert b == 200

// The elvis assignment operator can also 
// be useful in maps to set default values.
def m = [a: 1, b: 2]
m.a = 100
m.b ?= 200
m.c ?= 300

assert m.a == 100
assert m.b == 2
assert m.c == 300

// Also to set default values for properties
// in an object. Especially if we cannot
// change the class to set a default value.
// In our example we have the source of the
// Email class and we could set default values
// in the class definition, but if the class
// is not under our control we can use the
// elvis assignment operator to set default
// values easily.
class Email {
    String to, from, subject, body
}

def mail = new Email(to: 'test@mrhaki.com', 
                     subject: 'Sample', 
                     body: 'Trying Elvis assignment.')
mail.subject ?= 'Mail has no subject'
mail.from ?= 'no-reply@mrhaki.com'

assert mail.to == 'test@mrhaki.com'
assert mail.from == 'no-reply@mrhaki.com'
assert mail.subject == 'Sample'
assert mail.body == 'Trying Elvis assignment.'
