import static java.util.Calendar.*

def date = new Date()
date.set year: 2010, month: 11, date: 16

def calendar = date.toCalendar()

assert calendar[YEAR] == 2010
assert calendar[MONTH] == Calendar.DECEMBER
assert calendar[DATE] == 16
assert calendar.format('dd-MM-yyyy') == '16-12-2010'
assert calendar in Calendar
