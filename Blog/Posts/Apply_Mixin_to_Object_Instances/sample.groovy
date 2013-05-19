class Parrot {
    static String speak(Message text) {
        /"$text" Polly wants a cracker!/
    }
}

// Runtime mixin on String object instead of class. 
String s = 'Groovy is Gr8'
s.metaClass.mixin Parrot

assert s.speak() == '"Groovy is Gr8" Polly wants a cracker!'


String other = 'Groovy and Grails'
try {
    other.speak()
} catch (MissingMethodException e) {
    assert e.message.startsWith('No signature of method: java.lang.String.speak() is applicable for argument types: () values: []')
}
