import java.beans.*

def event 
// Listener will assign event to global event variable.
def listener = { 
    event = it
} as PropertyChangeListener

/* ObservableList */
def list = ['Groovy', 'rocks', 'the world', true] as ObservableList
list.addPropertyChangeListener(listener)

list << 'More text'
assert event instanceof ObservableList.ElementAddedEvent 
assert 4 == event.index
assert 'More text' == event.newValue

list.remove(3)
assert event instanceof ObservableList.ElementRemovedEvent
assert 3 == event.index

list[0] = 'Grails'
assert event instanceof ObservableList.ElementUpdatedEvent
assert 0 == event.index
assert 'Groovy' == event.oldValue
assert 'Grails' == event.newValue

list.addAll([42, 101])
assert event instanceof ObservableList.MultiElementAddedEvent
assert [42, 101] == event.values

list.removeAll([true, 'More text', 42, 101])
assert event instanceof ObservableList.MultiElementRemovedEvent
assert 3 == list.size()

list.clear()
assert event instanceof ObservableList.ElementClearedEvent
assert ['Grails', 'rocks', 'the world'] == event.values

event = null

// We can define a closure as a filter. The closure is
// executed for each element and if it returns true,
// the property change event is fired.
def strict = new ObservableList({ it.size() > 2 })
strict.addPropertyChangeListener(listener)
strict.addAll(['a', 'ab', 'abc', 'abcd'])
assert ['abc', 'abcd'] == event.values

/* ObservableMap */
event = null

// Extra property change listener to assign to a specific
// property instead of the whole map.
def propEvent
def propListener = { propEvent = it } as PropertyChangeListener

def map = [username: 'mrhaki', email: 'email@host.com', active: true] as ObservableMap
map.addPropertyChangeListener(listener)
map.addPropertyChangeListener("active", propListener)

map.location = "@work"
assert event instanceof ObservableMap.PropertyAddedEvent 
assert 'location' == event.propertyName
assert '@work' == event.newValue
assert !propEvent

map.active = false
assert event instanceof ObservableMap.PropertyUpdatedEvent 
assert propEvent instanceof ObservableMap.PropertyUpdatedEvent
assert true == propEvent.oldValue
assert false == propEvent.newValue
assert 'active' == event.propertyName

map.remove('active')
assert propEvent instanceof ObservableMap.PropertyRemovedEvent
assert 3 == map.size()

map.putAll([car: true, phone: '555-1234'])
assert event instanceof ObservableMap.MultiPropertyEvent 
assert event.events[0] instanceof ObservableMap.PropertyAddedEvent
assert 'car' == event.events[0].propertyName
assert true == event.events[0].newValue
assert event.events[1] instanceof ObservableMap.PropertyAddedEvent
assert 'phone' == event.events[1].propertyName
assert '555-1234' == event.events[1].newValue

map.clear()
assert event instanceof ObservableMap.PropertyClearedEvent
assert [username: 'mrhaki', car: true, phone: '555-1234', location: '@work', email: 'email@host.com'] == event.values

def strictMap = new ObservableMap({ name, value -> name ==~ /^a.*/ })
strictMap.addPropertyChangeListener(listener)
strictMap.putAll([a: 1, b: 2, c: 3])
assert 1 == event.events.size()
assert 'a' == event.events[0].propertyName
assert 1 == event.events[0].newValue
