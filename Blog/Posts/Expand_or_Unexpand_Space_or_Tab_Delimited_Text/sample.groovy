// Simple ruler to display 0 up to 30
def ruler = (0..30).inject('\n') { result, c -> 
    result += (c % 10) 
}

def stringWithTabs = 'Groovy\tGrails\tGriffon'

println ruler
println stringWithTabs.expand()  // default tab stop is 8
println stringWithTabs.expand(10)  // tab stop is 10

// Output:
// 0123456789012345678901234567890
// Groovy  Grails  Griffon
/ /Groovy    Grails    Griffon

assert 'Groovy  Grails  Griffon' == stringWithTabs.expand()
assert 'Groovy    Grails    Griffon' == stringWithTabs.expand(10)


def stringWithSpaces = 'Hubert  Klein   Ikkink'
def stringWithSpaces10 = 'Hubert    Klein     Ikkink'
println ruler
println stringWithSpaces
println stringWithSpaces10

// Output:
// 0123456789012345678901234567890
// Hubert  Klein   Ikkink
// Hubert    Klein     Ikkink

assert 'Hubert\tKlein\tIkkink' == stringWithSpaces.unexpand()
assert 'Hubert\tKlein\tIkkink' == stringWithSpaces10.unexpand(10)
