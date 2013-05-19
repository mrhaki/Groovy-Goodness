import static java.util.Calendar.*

def timeZone = TimeZone.getTimeZone('Europe/Amsterdam')
def otherTimeZone = TimeZone.getTimeZone('Australia/Canberra')

def cal = Calendar.instance
cal.set(year: 2011, month: OCTOBER, date: 20, hourOfDay: 12, minute: 30)

def date = cal.time
def dateFormat = 'yyyy/MM/dd HH:mm'

assert date.format(dateFormat, timeZone) == '2011/10/20 12:30'
assert date.format(dateFormat, otherTimeZone) == '2011/10/20 21:30'
