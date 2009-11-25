class Simple {
    String language

    def whatDoYouSpeak() {  
        language
    }

    def say(String text) {
        "You say $text in $language"
    }
}

def s = new Simple(language: 'Groovy')

assert s.metaClass.respondsTo(s, 'whatDoYouSpeak')
assert Simple.metaClass.respondsTo(s, 'say')
assert s.metaClass.respondsTo(s, 'say', String)
assert !s.metaClass.respondsTo(s, 'say', Integer)  // No say(Integer) method.
assert Simple.metaClass.respondsTo(s, 'toString')  // Method in parent object.

assert s.metaClass.hasProperty(s, 'language')
assert Simple.metaClass.respondsTo(s, 'getLanguage')  // Get/set methods are generated.
assert s.metaClass.respondsTo(s, 'setLanguage')
