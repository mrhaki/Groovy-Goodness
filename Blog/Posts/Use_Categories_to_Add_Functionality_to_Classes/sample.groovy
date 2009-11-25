class Speak {
    static String shout(String text) {  // Method argument is String, so we can add shout() to String object.
        text.toUpperCase() + '!'
    }

    static String whisper(String text, boolean veryQuiet = false) {
        "${veryQuiet ? 'sssssssh' : 'sssh'}.. $text"
    }

    static String army(String text) {
        "$text. Sir, yes sir!"
    }
}

use (Speak) {
    assert 'PAY ATTENTION!' == "Pay attention".shout()
    assert 'sssh.. Be vewy, vewy, quiet.' == "Be vewy, vewy, quiet.".whisper()
    assert 'sssssssh.. Be vewy, vewy, quiet.' == "Be vewy, vewy, quiet.".whisper(true)
    assert 'Groovy rocks. Sir, yes sir!' == "Groovy rocks".army()
}

// Or we can use the @Category annotation.
@Category(String) 
class StreetTalk {
    String hiphop() {
        "Yo, yo, here we go. ${this}"
    }
}

use(StreetTalk) {
    assert 'Yo, yo, here we go. Groovy is fun!' == 'Groovy is fun!'.hiphop()
}

// We can use static methods from other Java classes.
use (org.apache.commons.codec.digest.DigestUtils) {
    assert '900150983cd24fb0d6963f7d28e17f72' == 'abc'.md5Hex()
}
