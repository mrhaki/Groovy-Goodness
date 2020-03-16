import groovy.yaml.YamlBuilder

// Sample class and object to transform in YAML.
class User { String firstName, lastName, alias, website }
def userObj = new User(firstName: 'Hubert', lastName: 'Klein Ikkink', alias: 'mrhaki', website: 'https://www.mrhaki.com/') 


// Create YamlBuilder.
def config = new YamlBuilder()

config {
    application 'Sample App'
    version '1.0.1'
    autoStart true
    
    // We can nest YAML content.
    database {
        url 'jdbc:db//localhost'    
    }
    
    // We can use varargs arguments that will
    // turn into a list.
    // We could also use a Collection argument.
    services 'ws1', 'ws2'

    // We can even apply a closure to each
    // collection element.
    environments(['dev', 'acc']) { env -&gt;
        name env.toUpperCase()
        active true
    }

    // Objects with their properties can be converted.
    user(userObj)
}

assert config.toString() == '''\
---
application: "Sample App"
version: "1.0.1"
autoStart: true
database:
  url: "jdbc:db//localhost"
services:
- "ws1"
- "ws2"
environments:
- name: "DEV"
  active: true
- name: "ACC"
  active: true
user:
  firstName: "Hubert"
  alias: "mrhaki"
  lastName: "Klein Ikkink"
  website: "https://www.mrhaki.com/"
'''
