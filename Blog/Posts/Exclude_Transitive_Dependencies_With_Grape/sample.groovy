package com.mrhaki

@Grab('org.springframework:spring-context:4.2.1.RELEASE')
// Exclude the commons-logging dependency 
// as Spring transitive dependency.
@GrabExclude(group = 'commons-logging', module='commons-logging') // Or 'commons-logging:commons-logging'
// Replace commons-logging with SLF4J 
// implementation Logback.
@Grab('org.slf4j:jcl-over-slf4j:1.7.12')
@Grab('ch.qos.logback:logback-classic:1.1.3')
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.AnnotationConfigApplicationContext


// Define Spring Java (Groovy) configuration class.
@Configuration
class AppConfig {

    // Simple bean is a String.
    @Bean
    String obvious() {
        'Groovy is gr8!'
    }
}

// Create new Spring application context and use
// our Groovy configuration class
final ApplicationContext appContext = 
    new AnnotationConfigApplicationContext(AppConfig)

// Check that bean is in application context.
assert appContext.getBean('obvious') == 'Groovy is gr8!'
