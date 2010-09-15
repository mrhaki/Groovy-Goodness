def s = '''\
        |Groovy
        |Grails
        |Griffon'''
        
assert '''\
Groovy
Grails
Griffon''' == s.stripMargin()

def s1 = '''\
   * Gradle
   * GPars
   * Spock''' 
   
assert '''\
 Gradle
 GPars
 Spock''' == s1.stripMargin("* ")
