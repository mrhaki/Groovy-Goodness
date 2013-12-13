import org.codehaus.groovy.control.CompilerConfiguration
 
// Simple Car class to save state and distance.
class Car {
    String state
    Long distance = 0
}

// Custom Script with methods that change the Car's state.
// The Car object is passed via the constructor.
class CarScript {

    private final car
    
    CarScript(final car) {
        this.car = car
    }

    def start() {
        car.state = 'started'
    }

    def stop() {
        car.state = 'stopped'
    }

    def drive(distance) {
        car.distance += distance
    }
}

// Create CompilerConfiguration and assign
// the DelegatingScript class as the base script class.
def compilerConfiguration = new CompilerConfiguration()
compilerConfiguration.scriptBaseClass = DelegatingScript.class.name

// Configure the GroovyShell and pass the compiler configuration.
def shell = new GroovyShell(this.class.classLoader, new Binding(), compilerConfiguration)


// Simple DSL to start, drive and stop the car.
// The methods are defined in the CarScript class.
def carDsl = '''
start()
drive 200
stop()
'''


// Define Car object here, 
// so we can use it in assertions later on.
def car = new Car()

// Define CarScript instance so we can use it as delegate
// for the script.
def carScript = new CarScript(car)

// Set delegate carScript to script, so the DSL
// can be executed.
def script = shell.parse(carDsl)
script.setDelegate(carScript)

// Run DSL script.
script.run()

// Checks to see that Car object has changed.
assert car.distance == 200
assert car.state == 'stopped'
