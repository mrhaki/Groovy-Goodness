// Internal JDK class location is null.
assert String.location == null


// Import ConfigSlurper with alias.
import groovy.util.ConfigSlurper as ConfigReader

// Location of Groovy JAR file.
def groovyJarFile = 'file:/Users/mrhaki/.sdkman/candidates/groovy/2.5.0/lib/groovy-2.5.0.jar'.toURL()   

// ConfigSlurper is located in the Groovy JAR file.
assert ConfigSlurper.location == groovyJarFile

// Works also for aliased class.
assert ConfigReader.location == groovyJarFile                                                 
