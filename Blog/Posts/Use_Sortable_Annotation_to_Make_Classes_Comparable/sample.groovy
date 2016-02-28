final Comparator byMaxAttendees = Course.comparatorByMaxAttendees()
final List<course> sortedByMaxAttendees = courses.sort(false, byMaxAttendees)

assert sortedByMaxAttendees.maxAttendees == [20, 40, 50]
// beginDate is not used for sorting
assert sortedByMaxAttendees[2].beginDate &lt; sortedByMaxAttendees[1].beginDate

assert Course.declaredMethods.name.findAll { it.startsWith('comparatorBy') } == ['comparatorByTitle', 'comparatorByMaxAttendees']
