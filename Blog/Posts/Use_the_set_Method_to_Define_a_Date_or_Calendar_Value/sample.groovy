import static java.util.Calendar.*

def cal = Calendar.instance
cal.set(year: 2010, month: JULY, date: 9)

assert 'Birthday @ 2010-7-9' == 'Birthday @ ' + cal.format('yyyy-M-d')
assert FRIDAY == cal[DAY_OF_WEEK]

def date = new Date()
date.set(hourOfDay: 12, minute: 0, second: 0, year: 2010, month: JUNE, date: 1)

assert '12:00:00' == date.format('HH:mm:ss')
assert 2010 == date[YEAR]
assert JUNE == date[MONTH]
assert 1 == date.getAt(DATE)
