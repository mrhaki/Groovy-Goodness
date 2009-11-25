def s = "Programming with Groovy is fun!"

assert "Programming with Groovy rocks!" == s.replaceAll(~/is fun!/, "rocks!")  // Groovy extension to String.
assert "Programming with Groovy is awesome." == s.replaceAll("fun!", "awesome.")  // java.lang.String.replaceAll.

// Replace found String with result of closure.
def replaced = s.replaceAll(/fun/) {
    def list = ['awesome', 'cool', 'okay']
    list[new Random().nextInt(list.size())]
}
assert [
    "Programming with Groovy is awesome!",
    "Programming with Groovy is cool!",
    "Programming with Groovy is okay!"
].contains(replaced)

// Use closure to replace text and use grouping. 
// First closure parameter is complete string and following
// parameters are the groups.
def txt = "Generated on 30-10-2009 with Groovy."
def replacedTxt = txt.replaceAll(/.*(\d{2}-\d{2}-\d{4}).*(Gr.*)./) { all, date, lang ->
    def dateObj = Date.parse('dd-MM-yyyy', date)
    "The text '$all' was created with $lang on a ${dateObj.format('EEEE')}."
}
assert "The text 'Generated on 30-10-2009 with Groovy.' was created with Groovy on a Friday." == replacedTxt
