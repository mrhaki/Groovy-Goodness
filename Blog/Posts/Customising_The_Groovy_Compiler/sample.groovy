// File: build.gradle
plugins {
    id "groovy"
}

repositories {
    jcenter()
}

dependencies {
    compile "org.codehaus.groovy:groovy-all:2.4.5"
    testCompile "org.spockframework:spock-core:1.0-groovy-2.4"
}

// Add the configuration script file
// to the compiler options.
compileGroovy.groovyOptions.configurationScript = file('src/groovyCompile/groovycConfig.groovy')
