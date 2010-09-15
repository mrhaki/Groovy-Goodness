import static java.util.Calendar.*

// Create date object with specific year, month and day.
def date = new Date()
date.clearTime()
date.set year: 2010, month: AUGUST, date: 10

// Convert to java.sql.Timestamp.
def sqlTimestamp = date.toTimestamp()
assert 'java.sql.Timestamp' == sqlTimestamp.class.name
assert '2010-08-10 00:00:00.0' == sqlTimestamp.toString()
