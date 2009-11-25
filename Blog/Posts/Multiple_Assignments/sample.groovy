// Assign and declare variables.
def (username, email) = ['mrhaki', 'email@host.com']
assert 'mrhaki' == username
assert 'email@host.com' == email

// We can assign later than the definition of the variables.
int housenr
String streetname
(streetname, housenr) = ['Old Street', 42]
assert 42 == housenr
assert 'Old Street' == streetname

// Return value of method can be assigned to multiple variables.
def iAmHere() {
    [29.20090, 12.90391]
}
def (coordX, coordY) = iAmHere()
assert coordX == 29.20090
assert coordY == 12.90391

// More values than variables: extra values are ignored.
def (a, b, c) = ['a', 'b', 'c', 'd']
assert 'a' == a
assert 'b' == b
assert 'c' == c

// Less values than variables: variable is not set.
def (x, y, z) = [100, 200]
assert 100 == x
assert 200 == y
assert !z

// Useful for getting regular expressions matching groups.
def money  = '12 Euro' 
def regexp = /(\d+) (\w+)/
def (exp, amount, currency) = (money =~ regexp)[0]
assert '12' == amount
assert 'Euro' == currency

