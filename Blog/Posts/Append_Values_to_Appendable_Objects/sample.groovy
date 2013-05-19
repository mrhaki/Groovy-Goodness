// Create object that implements the Appendable interface.
final Appendable appendable = new StringWriter()

assert appendable in Appendable


// Use leftShift operator to add to Appendable implementation.
appendable &lt;&lt; 'Groovy is Gr8!' &lt;&lt; newLine


// Use withFormatter() method.
// Formatter object 
// is passed to closure as parameter.
appendable.withFormatter { formatter ->
    // Simple formatter pattern to reorder the arguments.
    formatter.format(/m r %3$1s %2$1s %1$1s %4$1s%n/, 'k', 'a', 'h', 'i')
}


// Use withFormatter() method and use Locale object
// as extra argument. The Locale is passed on
// to create the Formatter object.
appendable.withFormatter(Locale.US) { formatter ->
    formatter.format("US: " + datePattern, date)
}
// Use different Locale.
appendable.withFormatter(new Locale('nl')) { formatter ->
    formatter.format("Dutch: $datePattern", date)
}


// Check result is as expected:
assert appendable.toString() == '''Groovy is Gr8!
m r h a k i
US: January 27, 2013
Dutch: januari 27, 2013
'''


// Helper getters:

String getNewLine() {
    System.getProperty('line.separator')
}

Date getDate() {
    // Simple date to use in withFormatter() methods.
    Date.parse('yyyy-MM-dd', '2013-01-27')
}

String getDatePattern() {
    // Date pattern for Formatter.
    '%1$tB %1$te, %1$tY%n'
}
