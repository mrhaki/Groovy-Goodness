@Grapes([
    @Grab(group='com.h2database', module='h2', version='1.3.160'),
    @GrabConfig(systemClassLoader = true)
])
import com.h2database.*
import groovy.sql.*

def db = Sql.newInstance('jdbc:h2:mem:', 'sa', '', 'org.h2.Driver')

// Setup database.
db.execute '''
    create table if not exists languages(
        id int primary key,
        name varchar(20) not null
    )
'''

db.execute "insert into languages values(1, 'Groovy')"
db.execute "insert into languages values(2, 'Java')"

// Sample of meta closure:
String query = 'select id as identifier, name as langName from languages'
def rows = db.rows(query, { meta ->
    assert meta.tableName == 'languages'
    assert meta.columnCount == 2

    assert meta.getColumnLabel(1) == 'IDENTIFIER'
    assert meta.getColumnName(1) == 'ID'
    assert meta.getColumnTypeName(1) == 'INTEGER'

    assert meta.getColumnLabel(2) == 'LANGNAME'
    assert meta.getColumnName(2) == 'NAME'
    assert meta.getColumnTypeName(2) == 'VARCHAR'
})
