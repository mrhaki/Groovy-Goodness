// Builder syntax to create a reservation with passengers,
// departing and destination airport and make it a 2-way flight.
def reservation = new ReservationBuilder().make {
    passengers {
        name 'mrhaki'
        name 'Hubert A. Klein Ikkink'
    }
    from 'Schiphol, Amsterdam'
    to 'Kastrup, Copenhagen'
    retourFlight
}

assert reservation.flight.from == new Airport(name: 'Schiphol', city: 'Amsterdam')
assert reservation.flight.to == new Airport(name: 'Kastrup', city: 'Copenhagen')
assert reservation.passengers.size() == 2
assert reservation.passengers == [new Person(name: 'mrhaki'), new Person(name: 'Hubert A. Klein Ikkink')]
assert reservation.retourFlight


// ----------------------------------------------
// Builder implementation and supporting classes.
// ----------------------------------------------
import groovy.transform.*

@Canonical
class Reservation {
    Flight flight = new Flight()
    List&lt;Person&gt; passengers = []
    Boolean retourFlight = false
}

@Canonical
class Person { String name }

@Canonical
class Airport { String name, city }

@Canonical
class Flight { Airport from, to }

// The actual builder for reservations.
class ReservationBuilder {
    // Reservation to make and fill with property values.
    Reservation reservation

    private Boolean passengersMode = false

    Reservation make(Closure definition) {
        reservation = new Reservation()

        runClosure definition

        reservation
    }

    void passengers(Closure names) {
        passengersMode = true

        runClosure names

        passengersMode = false
    }

    void name(String personName) {
        if (passengersMode) {
            reservation.passengers &lt;&lt; new Person(name: personName)
        } else {
            throw new IllegalStateException("name() only allowed in passengers context.")
        }
    }

    def methodMissing(String name, arguments) {
        // to and from method calls will set flight properties
        // with Airport objects.
        if (name in ['to', 'from']) {
            def airport = arguments[0].split(',')
            def airPortname = airport[0].trim()
            def city = airport[1].trim()
            reservation.flight."$name" = new Airport(name: airPortname, city: city)
        }
    }

    def propertyMissing(String name) {
        // Property access of retourFlight sets reservation
        // property retourFlight to true.
        if (name == 'retourFlight') {
            reservation.retourFlight = true
        }
    }

    private runClosure(Closure runClosure) {
        // Create clone of closure for threading access.
        Closure runClone = runClosure.clone()

        // Set delegate of closure to this builder.
        runClone.delegate = this

        // And only use this builder as the closure delegate.
        runClone.resolveStrategy = Closure.DELEGATE_ONLY

        // Run closure code.
        runClone()
    }

}
