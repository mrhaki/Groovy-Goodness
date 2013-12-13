import groovy.beans.*
import java.beans.*

@Bindable
class User {
    String name, email
}

def u = new User(name: 'mrhaki', email: 'mrhaki@mrhaki.com')

// Assign closure as implementation of single abstract method onPropertyChange
// in abstract class ChangedProperty.
ChangedProperty changedProperty = { event -> 
    println "Changed property $event.propertyName from $event.oldValue to $event.newValue" 
}
u.addPropertyChangeListener changedProperty

u.name = 'Hubert A. Klein Ikkink'
// Output: Changed property name from mrhaki to Hubert A. Klein Ikkink

u.email = 'hubert@mrhaki.com'
// Output: Changed property email from mrhaki@mrhaki.com to hubert@mrhaki.com

assert changedProperty.events.size() == 2
assert changedProperty.events.first().oldValue == 'mrhaki'
assert changedProperty.events.first().newValue == 'Hubert A. Klein Ikkink'

abstract class ChangedProperty implements PropertyChangeListener {

    List&lt;PropertyChangeEvent&gt; events = []

    void propertyChange(PropertyChangeEvent event) {
        events &lt;&lt; event
        onPropertyChange(event);
    }
    
    abstract void onPropertyChange(PropertyChangeEvent event)

}
