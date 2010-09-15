import groovy.mock.interceptor.*

class CallServiceTest extends GroovyTestCase {
    def callService = new CallService()
    
    void testServiceCall() {
        def stub = new StubFor(MyService.class)
        stub.demand.findLanguages { ['Java', 'Groovy'] }  // Return one language with an 'a' and one without.
        stub.use {
            callService.myService = new MyService()
            def result = callService.findLanguagesWithA()  // Will use method from stub.
            assert 1 == result.size()
            assert 'Java' == result[0]
        }
    }
    
    void testEmptyResult() {
        def stub = new StubFor(MyService.class)
        stub.demand.findLanguages { ['Groovy', 'Clojure'] }  // Return no languages with an 'a'.
        stub.use {
            callService.myService = new MyService()
            def result = callService.findLanguagesWithA()  // Method from stub is invoked.
            assert !result
        }
    }
}

class CallService {
    def myService = new MyService()
    
    List findLanguagesWithA() {
        def languages = myService.findLanguages()
        languages.grep({ it.contains('a') })
    }
}
class MyService {
    List findLanguages() {
        // Get real data from database for example.
        // That is why we want to stub this class, so we don't rely on
        // the database.
        []
    }
}
