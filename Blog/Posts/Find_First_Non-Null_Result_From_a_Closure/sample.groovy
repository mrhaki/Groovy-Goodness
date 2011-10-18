def list = ['Groovy', 'Griffon', 'Grails', 'Gradle']

assert list.findResult { it.startsWith('Gra') ? it : null } == 'Grails'
assert list.findResult('Gr8') { 
    if (it.size() < 6) {
        "found text with size smaller than 6"
    }
} == 'Gr8'
