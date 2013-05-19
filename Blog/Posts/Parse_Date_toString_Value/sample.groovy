import static java.util.Calendar.*

// Create date 10 November 2011.
def cal = Calendar.getInstance(TimeZone.getTimeZone('Europe/Amsterdam'))
def date = cal.time
date.clearTime()
date[YEAR] = 2011
date[MONTH] = NOVEMBER
date[DATE] = 10

// Get toString() value.
def dateToString = date.toString()
assert dateToString == 'Thu Nov 10 00:00:00 CET 2011'

// Replace Nov for Dec in string and 10 for 24.
dateString = dateToString.replace('Nov', 'Dec').replace('10', '24')

// Use parseToStringDate to get new Date.
def newDate = Date.parseToStringDate(dateString)
assert newDate[MONTH] == DECEMBER
assert newDate[DATE] == 24
assert newDate[YEAR] == 2011
