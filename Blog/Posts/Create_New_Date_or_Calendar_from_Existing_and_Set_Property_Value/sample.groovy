import static java.util.Calendar.NOVEMBER

// Create original date.
def date = new Date().clearTime()
date.set(year: 2013, month: NOVEMBER, date: 18)

// Use copyWith to get new Date and 
// immmediatelly set year to 2014.
def yearLater = date.copyWith(year: 2014)

assert yearLater.format('dd-MM-yyyy') == '18-11-2014'


// Also works for Calendar.
def cal = Calendar.instance
cal.set(year: 2013, month: NOVEMBER, date: 10)

// Create new Calendar with new date value.
def newCalendar = cal.copyWith(date: 18)

assert newCalendar.format('dd-MM-yyyy') == '18-11-2013'
