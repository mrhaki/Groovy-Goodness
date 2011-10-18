import groovy.transform.*

@Canonical
class Building {
    String name
    int floors
    boolean officeSpace
}

// Constructors are added.
def officeSpace = new Building('Initech office', 1, true)

// toString() added.
assert officeSpace.toString() == 'Building(Initech office, 1, true)'

// Default values are used if constructor
// arguments are not assigned.
def theOffice = new Building('Wernham Hogg Paper Company')
assert theOffice.floors == 0
theOffice.officeSpace = true

def anotherOfficeSpace = new Building(name: 'Initech office', floors: 1, officeSpace: true)

// equals() method is added.
assert anotherOfficeSpace == officeSpace

// equals() and hashCode() are added, so duplicate is not in Set.
def offices = [officeSpace, anotherOfficeSpace, theOffice] as Set  
assert offices.size() == 2 
assert offices.name.join(',') == 'Initech office,Wernham Hogg Paper Company'

@Canonical
@ToString(excludes='age')  // Customize one of the transformations.
class Person {
    String name
    int age
}

def mrhaki = new Person('mrhaki', 37)
assert mrhaki.toString() == 'Person(mrhaki)'
