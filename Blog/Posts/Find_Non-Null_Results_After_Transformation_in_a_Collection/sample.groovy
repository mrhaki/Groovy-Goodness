def stuff = ['Groovy', 'Griffon', 'Gradle', 'Spock', 'Grails', 'GContracts']
def stuffResult = stuff.findResults { it.size() == 6 ? "$it has 6 characters" : null }

assert stuffResult == ['Groovy has 6 characters', 
                       'Gradle has 6 characters',
                       'Grails has 6 characters']
                        
def map = [what: 'Finish blog post', priority: 1, when: new Date()]
def mapResult = map.findResults { it.value instanceof String ? "Key $it.key is of type String" : null }

assert mapResult == ['Key what is of type String']
