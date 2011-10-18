import static java.util.Calendar.*

class User {
    String name
    String city
    Date birthDate
    public String toString() { name }
}

def users = [
    new User(name:'mrhaki', city: 'Tilburg',   birthDate: Date.parse('yyyy-MM-dd', '1973-9-7')),
    new User(name:'bob',    city: 'New York',  birthDate: Date.parse('yyyy-MM-dd', '1963-3-30')),
    new User(name:'britt',  city: 'Amsterdam', birthDate: Date.parse('yyyy-MM-dd', '1980-5-12')),
    new User(name:'kim',    city: 'Amsterdam', birthDate: Date.parse('yyyy-MM-dd', '1983-3-30')),
    new User(name:'liam',   city: 'Tilburg',   birthDate: Date.parse('yyyy-MM-dd', '2009-3-6'))
]

def result = users.groupBy({it.city}, {it.birthDate.format('MMM')})

assert result.toMapString() == 
    '[Tilburg:[Sep:[mrhaki], Mar:[liam]], New York:[Mar:[bob]], Amsterdam:[May:[britt], Mar:[kim]]]'

assert result.Amsterdam.size() == 2
assert result.Tilburg.Mar.name == ['liam']

result = users.groupBy({it.name[0]}, {it.city})
assert result.toMapString() ==
    '[m:[Tilburg:[mrhaki]], b:[New York:[bob], Amsterdam:[britt]], k:[Amsterdam:[kim]], l:[Tilburg:[liam]]]'
assert result.k.Amsterdam.name == ['kim']  

// groupBy with multiple closues also works on Map
def usersByCityMap = users.groupBy({it.city})
def resultMap = usersByCityMap.groupBy({it.value.size()}, { k,v -> k.contains('i') })
assert resultMap.toMapString() ==
    '[2:[true:[Tilburg:[mrhaki, liam]], false:[Amsterdam:[britt, kim]]], 1:[false:[New York:[bob]]]]'
assert resultMap[1].size() == 1
assert resultMap[2].size() == 2
assert resultMap[2][true].Tilburg.name.join(',') == 'mrhaki,liam'
