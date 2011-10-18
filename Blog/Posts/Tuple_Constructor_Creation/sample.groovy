// include properties and fields from super class.
import groovy.transform.TupleConstructor

@TupleConstructor(includeFields=true)
class Person {
    String name
    List likes
    private boolean active = false

    boolean isActivated() { active }
}

@TupleConstructor(callSuper=true, includeSuperProperties=true, includeSuperFields=true)
class Student extends Person {
    List courses
}

def student = new Student('mrhaki', ['Groovy', 'Java'], true, ['IT'])

assert student.name == 'mrhaki'
assert student.likes == ['Groovy', 'Java']
assert student.activated
assert student.courses == ['IT']
