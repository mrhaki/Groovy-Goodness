import groovy.transform.Immutable

@Immutable(copyWith = true)
class User {
    String name
    String email
}

// Create immutable instance of User.
def mrhaki = new User('mrhaki', 'mrhaki@mrhaki.com')

mrhaki.with {
    assert name == 'mrhaki'
    assert email == 'mrhaki@mrhaki.com'
}

// Use new copyWith method to create a new immutable
// instance of the User class where name property
// is changed and email property is unchanged.
def hubert = mrhaki.copyWith(name: 'Hubert A. Klein Ikkink')

hubert.with {
    assert name == 'Hubert A. Klein Ikkink'
    assert email == 'mrhaki@mrhaki.com'
}

// The properties are still immutable:
try {
    hubert.email = 'new-mail@host.nl'
} catch (ReadOnlyPropertyException e) {
    assert 'Cannot set readonly property: email for class: User' == e.message
}
