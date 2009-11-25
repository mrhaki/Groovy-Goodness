// Date.parse() to convert String to Date.
date = new Date().parse('yyyy/MM/dd', '1973/07/09')

// We can use [] or getAt() to get date fields.
assert 1973 == date[Calendar.YEAR]
assert 6 == date[Calendar.MONTH]
assert 9 == date.getAt(Calendar.DATE)

dateNext = date.clone()
datePrevious = date.clone()

// We can use the + and - operators to add or 
// subtract days.
nextDay = date + 1  // Or date.plus(1)
previousDay = date - 1  // Or date.minus(1)

// ++ operator to move one day ahead.
dateNext++  // Or dateNext.next()
assert dateNext == nextDay

// -- operator to move one day back.
datePrevious--  // Or datePrevious.previous()
assert datePrevious == previousDay

otherDate = new Date().parse('yyyy/MM/dd', '1973/07/21')
// Dates can be used in ranges.
assert 12 == (otherDate..<date).size()

// Set Locale to assert date formatting.
Locale.setDefault(Locale.US)

// Date.format() uses java.text.SimpleDateFormat.
assert '9 July, 1973' == date.format("d MMMM, yyyy")
assert '7/9/73' == date.getDateString()
