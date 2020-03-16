/** 
 * Sample class with some properties
 * and a method.
 */
class Sample {
    
    String username, email
    
    List&lt;String&gt; labels = []
    
    void addLabel(value) { 
        labels &lt;&lt; value 
    }
    
}

def sample = 
        new Sample().tap {
            username = 'mrhaki'
            email = 'email@host.com'
            addLabel 'Groovy'
            addLabel 'Gradle'
        }

// The with method can be very useful to
// transform object to another type using
// values from the object.
def user = sample.with { "$username likes ${labels.join(', ')}." }

assert user == 'mrhaki likes Groovy, Gradle.'
