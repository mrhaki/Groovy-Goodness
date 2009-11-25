class User {
    String name
    String city
    Date birthDate
    public String toString() { "$name" }
}

def users = [
    new User(name:'mrhaki', city:'Tilburg', birthDate:new Date(73,9,7)),
    new User(name:'bob', city:'New York', birthDate:new Date(63,3,30)),
    new User(name:'britt', city:'Amsterdam', birthDate:new Date(80,5,12)),
    new User(name:'kim', city:'Amsterdam', birthDate:new Date(83,3,30)),
    new User(name:'liam', city:'Tilburg', birthDate:new Date(109,3,6))
]

// Helper closure for asserts.
def userToString = { it.toString() }

// Group by city property of user object:
def usersByCity = users.groupBy({ user -> user.city })
assert 2 == usersByCity["Tilburg"].size()
assert ['mrhaki', 'liam'] == usersByCity["Tilburg"].collect(userToString) 
assert ['bob'] == usersByCity["New York"].collect(userToString)
assert ['britt', 'kim'] == usersByCity["Amsterdam"].collect(userToString)

// Group by year of birthdate property of user object:
def byYear = { u -> u.birthDate[Calendar.YEAR] }
def usersByBirthDateYear = users.groupBy(byYear)
assert ['mrhaki'] == usersByBirthDateYear[1973].collect(userToString)

// Just a little fun with the closure:
def groupByGroovy = { 
    if (it =~ /y/) {
        "Contains y"
    } else {
        "Doesn't contain y"
    }
}
assert ["Contains y":["Groovy"], "Doesn't contain y":["Java", "Scala"]] == ['Groovy', 'Java', 'Scala'].groupBy(groupByGroovy)
