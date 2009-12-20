// Two simple closure with one and two parameters.
def one = { it.toUpperCase() }
def two = { String s, upper ->
    if (upper) {
        s.toUpperCase()
    } else {
        s.toLowerCase()
    }
}

def runClosure(cl) {
    switch (cl.maximumNumberOfParameters) {
        case 1: 
            assert [java.lang.Object] == cl.parameterTypes
            cl.call('Groovy')
            break
        case 2:
            assert [java.lang.String, java.lang.Object] == cl.parameterTypes
            cl('Groovy', false)
            break
    } 
}

assert 'GROOVY' == runClosure(one)
assert 'groovy' == runClosure(two)
