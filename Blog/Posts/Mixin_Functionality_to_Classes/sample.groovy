class Pirate {
    def talk(text) {
        "Aargh, walk the plank. ${text}"
    }
}

// Compile time mixin to Talk class. This add all
// methods from Pirate to Talk.
@Mixin(Pirate)  
class Talk {}

assert 'Aargh, walk the plank. Give me a bottle of rum.' == new Talk().talk("Give me a bottle of rum.")

import org.apache.commons.lang.StringUtils

class Parrot {
    static String speak(String text) {
        /Parrot says "$text"/
    }
}

// Runtime mixin on String class. 
// mixin() is a GDK extension to Class.
String.mixin Parrot, StringUtils

assert 'Parrot says "mrhaki"' == 'mrhaki'.speak()
assert 'Groovy is so much...' == 'Groovy is so much fun.'.abbreviate(20)  // StringUtils mixin.
