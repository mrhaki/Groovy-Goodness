import groovy.transform.*

/**
 * Simple class to describe
 * a Building.
 */
@Canonical
class Building {
    String name
    int floors
    boolean officeSpace
}

// Create Building objects.
def officeSpace = new Building('Initech office', 3, true)
def theOffice = new Building('Wernham Hogg Paper Company', 4, true)
def coffeeShop = new Building('Hunter Green', 1, false)

// And add to a list.
def buildings = [officeSpace, theOffice, coffeeShop]

// Create a closure which we will use 
// later in our code.
def mapBuildingName = { building -> building.name }


// Invoke Java Streams API with lambda methods,
// but we use Groovy closures.
def officeBuildingNames = 
    buildings
        .stream() // Get Java streams.
        .filter { building -> 
            building.officeSpace && building.floors > 2 
        } // 'anonymous' closure.
        .map(mapBuildingName) // Predefined closure.
        .collect()
        
assert officeBuildingNames == ['Initech office', 'Wernham Hogg Paper Company']
