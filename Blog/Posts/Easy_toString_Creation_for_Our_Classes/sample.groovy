// excludes active field and likes property from output
import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true, excludes='active,likes')
class Person {
    String name
    List likes
    private boolean active = false
}

def person = new Person(name: 'mrhaki', likes: ['Groovy', 'Java'])

assert person.toString() == 'Person(name:mrhaki)'
