def gr8Tech = ['Groovy', 'Grails', 'Spock', 'Gradle', 'Griffon']

// Since Groovy 2.4 we can use the init method.
assert gr8Tech.init() == ['Groovy', 'Grails', 'Spock', 'Gradle']
assert gr8Tech.last() == 'Griffon'


assert gr8Tech.head() == 'Groovy'
assert gr8Tech.tail() == ['Grails', 'Spock', 'Gradle', 'Griffon']
