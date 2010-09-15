// Create new date.
def d = new Date(year: 2010, month: Calendar.JULY, date: 1, 
                                hours: 7, minutes: 12, seconds: 0)

assert '7/1/10 7:12:00 AM' == d.dateTimeString

// Reset time portion of the date.
d.clearTime()

assert '7/1/10 12:00:00 AM' == d.dateTimeString
