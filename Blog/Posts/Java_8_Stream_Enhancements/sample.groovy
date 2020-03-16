def sample = ['Groovy', 'Gradle', 'Grails', 'Spock'] as String[]

def result = sample.stream()  // Use stream() on array objects
                   .filter { s -> s.startsWith('Gr') } 
                   .map { s -> s.toUpperCase() }
                   .toList()  // toList() added to Stream by Groovy
                   
assert result == ['GROOVY', 'GRADLE', 'GRAILS']


def numbers = [1, 2, 3, 1, 4, 2, 5, 6] as int[]

def even = numbers.stream()  // Use stream() on array objects
                  .filter { n -> n % 2 == 0 }
                  .toSet()  // toSet() added to Stream 
                  
assert even == [2, 4, 6] as Set
