def finder = ('groovy' =~ /gr.*/)
assert finder instanceof java.util.regex.Matcher

def matcher = ('groovy' ==~ /gr.*/)
assert matcher instanceof Boolean

assert 'Groovy rocks!' =~ /Groovy/  // =~ in conditional context returns boolean.
assert !('Groovy rocks!' ==~ /Groovy/)  // ==~ looks for an exact match.
assert 'Groovy rocks!' ==~ /Groovy.*/

def cool = /gr\w{4}/  // Start with gr followed by 4 characters.
def findCool = ('groovy, java and grails rock!' =~ /$cool/)
assert 2 == findCool.count
assert 2 == findCool.size()  // Groovy adds size() method.
assert 'groovy' == findCool[0]  // Array-like access to match results.
assert 'grails' == findCool.getAt(1)

// With grouping we get a multidimensional array.
def group = ('groovy and grails, ruby and rails' =~ /(\w+) and (\w+)/)
assert group.hasGroup()
assert 2 == group.size()
assert ['groovy and grails', 'groovy', 'grails'] == group[0]
assert 'rails' == group[1][2]

// Use matcher methods.
assert 'Hi world' == ('Hello world' =~ /Hello/).replaceFirst('Hi')

// Groovy matcher syntax can be used in other methods.
assert ['abc'] == ['def', 'abc', '123'].findAll { it =~ /abc/ }
assert [false, false, true] == ['def', 'abc', '123'].collect { it ==~ /\d{3}/ }
