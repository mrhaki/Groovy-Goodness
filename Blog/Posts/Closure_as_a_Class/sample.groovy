class IsNumber extends Closure&lt;Boolean&gt; /* return type for closure as generic type */ {

    IsNumber() {
        super(null)
    }

    /**
     * Implementation of closure.
     */
    Boolean doCall(final Object value) {
        // Check if value is a number, if so
        // return true, otherwise false.
        value in Number
    }

}

def list = ['a', 100, 'Groovy', 1, 8, 42.0, true]

def numbers = list.findAll(new IsNumber())

assert numbers == [100, 1, 8, 42.0]
