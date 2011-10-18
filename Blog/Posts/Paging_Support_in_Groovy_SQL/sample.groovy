@Grapes([
    @Grab(group='com.h2database', module='h2', version='1.3.154'),
    @GrabConfig(systemClassLoader = true)
])
import groovy.sql.*

def sql = Sql.newInstance('jdbc:h2:./test', 'sa', '', 'org.h2.Driver')
sql.execute 'drop table if exists languages'
sql.execute '''
    create table languages(
        id integer not null auto_increment,
        name varchar(20) not null,
        primary key(id)
    )
'''

['Groovy', 'Java', 'Scala', 'JRuby', 'Clojure', 'Jython'].each {
    sql.execute "insert into languages(name) values($it)"
}

// Use paging to set offset to 1 and maximum results to 2.
sql.eachRow('select * from languages', 1, 2) { row -&gt;
    def expectedName = (row.id == 1 ? 'Groovy' : 'Java')
    assert row.name == expectedName
}

// Offset is 3 for resulting resultset, maximum results is 3.
def result = sql.rows("select * from languages where name like 'J%'", 3, 3)
assert result.size() == 1
assert result[0].id == 6 && result[0].name == 'Jython'

sql.execute "drop table languages"

sql.close()
