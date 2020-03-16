package mrhaki

import groovy.sql.*

class SampleDAO {
    private static final String TABLE_NAME = 'sample'
    private static final String COLUMN_ID = 'id'
    private static final String COLUMN_NAME = 'name'
    private static final String COLUMN_DESCRIPTION = 'description'

    private final Sql sql = 
        Sql.newInstance(
            'jdbc:h2:test', 'sa', 'sa', 'org.h2.Driver')

    Long create() {
        // We need to use Sql.expand() in our GString query.
        // If we don't use it the GString variable expressions are interpreted 
        // as a placeholder in a SQL prepared statement, but we don't
        // that here.
        final query = 
            """
            INSERT INTO ${Sql.expand(TABLE_NAME)} DEFAULT VALUES
            """

        final insertedKeys = sql.executeInsert(query)
        return insertedKeys[0][0]
    }

    void updateDescription(final Long id, final String description) {
        // In the following GString SQL we need
        // Sql.expand(), because we use executeUpdate
        // with only the GString argument.
        // Groovy will extract all variable expressions and
        // use them as the placeholders
        // for the SQL prepared statement.
        // So to make sure only description and id are 
        // placeholders for the prepared statement we use
        // Sql.expand() for the other variables.
        final query = 
            """
            UPDATE ${Sql.expand(TABLE_NAME)} 
            SET ${Sql.expand(COLUMN_DESCRIPTION)} = ${description}
            WHERE ${Sql.expand(COLUMN_ID)} = ${id}
            """
        sql.executeUpdate(query)
    }

    void updateName(final Long id, final String name) {
        // In the following GString SQL we don't need
        // Sql.expand(), because we use the executeUpdate
        // method with GString argument AND argument
        // with values for the placeholders.
        final query = 
            """
            UPDATE ${TABLE_NAME} 
            SET ${COLUMN_NAME} = :nameValue
            WHERE ${COLUMN_ID} = :idValue
            """
        sql.executeUpdate(query, nameValue: name, idValue: id)
    }
}
