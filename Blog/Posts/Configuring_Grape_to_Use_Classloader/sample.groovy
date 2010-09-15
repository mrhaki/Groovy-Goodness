@Grapes([
 @Grab('org.slf4j:slf4j-simple:1.5.11'),
 @Grab('mysql:mysql-connector-java:5.1.12'),
 @GrabConfig(systemClassLoader = true)
])
import org.slf4j.*
import groovy.sql.*

def logger = LoggerFactory.getLogger('sql')

logger.info 'Initialize SQL'

def username = args[0]  // First argument passed to script.
def password = args[1]  // Second argument passed to script is password.
def sql = Sql.newInstance('jdbc:mysql://localhost/test', username, password, 'com.mysql.jdbc.Driver')

logger.info "Got myself a SQL connection: $sql"
