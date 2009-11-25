import groovy.sql.*

// Create connection to MySQL with classic JDBC DriverManager.
def db = Sql.newInstance("jdbc:mysql://localhost/groovy", 'groovy', 'groovy', 'com.mysql.jdbc.Driver')

// Create a new table
db.execute 'drop table if exists languages'
db.execute '''
    create table languages(
        id integer not null auto_increment,
        name varchar(20) not null,
        primary key(id)
    )
'''

// Create a DataSet.
def languageSet = db.dataSet("languages")
languageSet.add(id: null, name: 'Groovy')
languageSet.add(name: 'Java')  // If we don't add the id column the value null is used.
languageSet.add(name: 'JRuby')
languageSet.add(name: 'Scala')

// Get data with each method.
def result = []
languageSet.each {
    result << it.name
}
assert 4 == result.size()
assert ['Groovy', 'Java', 'JRuby', 'Scala'] == result

// Use findAll and sort to define a query condition.
def firstItems = languageSet.findAll { it.id < 3 }.sort { it.name }
// No database acccess yet, only the query is constructed.
// We can see the query with sql property and parameters with parameters property.
assert 'select * from languages where id > ? order by name' == firstItems.sql
assert [3] == firstItems.parameters

// We call each to really access the database.
firstItems.findAll { it.name == 'Groovy' }.each { row ->
    assert 1 == row.id
    assert 'Groovy' == row.name
}
