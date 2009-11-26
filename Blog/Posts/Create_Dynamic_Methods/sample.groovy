// Class to show methodMissing method implementation.
class LanguageList {
    // Simple list with three String values.
    def list = ['Java', 'Groovy', 'Scala']

    // Set metaClass property to ExpandoMetaClass instance.
    LanguageList() {
        def mc = new ExpandoMetaClass(LanguageList, false, true)
        mc.initialize()
        this.metaClass = mc
    }
    
    // Override for methodMissing.
    // If the given method name starts with find we try to search
    // for the String following find... in the list.
    // If the method doesn't exist for this class, we add it to 
    // the metaClass property, so next time the method is there.
    def methodMissing(String name, Object args) {
        if (name.startsWith('find')) {
            def result = list.find { it == name[4..-1] }
            // Add new method to class with metaClass.
            this.metaClass."$name" = {-> result + "[cache]" }
            result    
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }
}

// Test the methodMissing implementation:
def languages = new LanguageList()
assert 'Groovy' == languages.findGroovy()
assert 'Scala' == languages.findScala()
assert 'Java' == languages.findJava()
assert !languages.findRuby()

assert 'Groovy[cache]' == languages.findGroovy()
assert 'Scala[cache]' == languages.findScala()
assert 'Java[cache]' == languages.findJava()