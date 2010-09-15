import static java.util.Calendar.*

def cal = Calendar.instance
cal[MONTH] = DECEMBER
def calNextMonth = cal.updated(month: cal[MONTH] + 1, year: 2012)

assert JANUARY == calNextMonth[MONTH]
assert 2013 == calNextMonth[YEAR]

def date = new Date()
date.set(year: 2011, month: MAY, date: 5)
def dateTenYearsAgo = date.updated(year: date[YEAR] - 10)

assert '2011-5-5' == date.format('yyyy-M-d')
assert '2001-5-5' == dateTenYearsAgo.format('yyyy-M-d')
