class Address {
    String street, city
    int number    
}

class Person {
    String name
    Address address
    String phoneNumber

    def move(newAddress, newPhoneNumber) {
        address.street = newAddress.street
        address.number = newAddress['number']
        address.city   = newAddress."city"
        phoneNumber = newPhoneNumber
    }
}

def a = new Address(street: 'Main St.', number: 1, city: 'Duck City')
def p = new Person(name: 'mrhaki', address: a, phoneNumber: '555-123499102')

p.move(street: 'High Av.', city: 'New Yark', '00920120', number: 42)  
// Groovy transform the method invocation to:
// p.move([street: 'High Av.', number: 42, city: 'New Yark'], '555-00920120')

assert 'High Av.' == p.address.street
assert 42 == p.address.number
assert 'New Yark' == p.address.city
assert '555-00920120' == p.phoneNumber
assert 'mrhaki' == p.name
