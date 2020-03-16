def list = null

// Accessing null list or array 
// using index based access, 
// will throw NullPointerException when
// collection is null.
try {
    list[0]
} catch (NullPointerException npe) {
    assert npe
}

// Using ?[...] will not throw NullPointerException.
assert list?[0] == null

// Assignment are ignored when list is null.
list?[1] = 42
assert list?[1] == null

// When collection is not null we simply
// get the default behaviour for index based
// access of elements.
def values = ["Groovy", "rocks"]
assert values?[0] == "Groovy"
values?[2] = '!'
assert values?.join(" ") == "Groovy rocks !"

// We can use ?[key] for maps as well.
def info = null
assert info?['address'] == null
info?['address'] = 'unknown'
assert info?['address'] == null

def user = [alias: 'mrhaki', loves: 'Groovy']
assert user?['alias'] == 'mrhaki'
user?['country'] = 'The Netherlands'
assert user?['country'] == 'The Netherlands'
assert user?['age'] == null
