// File: src/test/groovy/com/mrhaki/groovy/PirateExtensionSpec.groovy
package com.mrhaki.groovy

import spock.lang.Specification

class PirateExtensionSpec extends Specification {

    def "likeAPirate method should work as instance method on a String value"() {
        given:
        final String originalText = "Hi, Groovy is the greatest language of the JVM."

        expect:
        originalText.likeAPirate() == "Yo-ho-ho, Groovy be th' greatest language o' th' JVM."
    }

    def "talkLikeAPirate method should work as static method on String class"() {
        expect:
        "Arr, me hearty, Groovy rocks!" == String.talkLikeAPirate() + " Groovy rocks!"
    }

}
