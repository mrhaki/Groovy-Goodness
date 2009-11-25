class Car {
    int numberOfDoors
    String model
    String brand
    boolean automatic
    double price

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', #doors: '${numberOfDoors}', automatic: '${automatic}', price: '${price}']"
    }
}

Car ford = new Car(brand: 'Ford', model: 'Focus', numberOfDoors: 4, automatic: false, price: 24995)
Car toyota =  new Car(brand: 'Toyota', model: 'Verso')
toyota.automatic = true  // Yes, this invokes setAutomatic.
toyota.setPrice(28919)  // Normal set invocation.
toyota.setNumberOfDoors 5  // In Groovy we can omit the parentheses.
println ford  // Output: [Car details => brand: 'Ford', model: 'Focus', #doors: '4', automatic: 'false', price: '24995.0']
println toyota // Output: [Car details => brand: 'Toyota', model: 'Verso', #doors: '5', automatic: 'true', price: '28919.0']

class CarReadonly {
    int numberOfDoors
    String model
    final String brand  // Readonly, public getter is generated, no setter.
    boolean automatic
    double price

    // Protected setter, public getter is still generated.
    protected void setModel(model) {
        this.model = modelName
    }

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', #doors: '${numberOfDoors}', automatic: '${automatic}', price: '${price}']"
    }
}

class CarProperties {
    int numberOfDoors
    String model
    String brand
    boolean automatic
    double price

    public void setBrand(brand) {
        this.brand = brand + ' (set via setter method)'
    }

    String toString() {
        "[Car details => brand: '${brand}', model: '${model}', #doors: '${numberOfDoors}', automatic: '${automatic}', price: '${price}']"
    }
}

CarProperties ford = new CarProperties(brand: 'Ford', model: 'Focus', numberOfDoors: 4, automatic: false, price: 24995)
println ford.brand  // Output: Ford (set via setter method)

ford.@brand = 'Overrule brand'
println ford.brand  // Output: Overrule brand
println ford.@brand  // Output: Overrule brand
