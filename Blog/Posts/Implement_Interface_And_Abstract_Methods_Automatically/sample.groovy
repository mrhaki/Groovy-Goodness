import groovy.transform.AutoImplement
import static groovy.test.GroovyAssert.shouldFail

// Sample class with two simple properties.
@groovy.transform.Canonical
class Course {
    String name, location
}

// Interface with a single method to 
// create an object based on Map argument.
interface Creator&lt;R&gt; {
    R create(Map args)
}


// Use AutoImplement annotation to create object
// implementing the Creator interface. The compiled
// class will have an implementation for the create
// method. The return value is the default of the
// return type, in our case null.
@AutoImplement
class DefaultCourseCreator implements Creator&lt;Course&gt; { }

def defaultCreator = new DefaultCourseCreator()
assert defaultCreator.create(name: 'Groovy', location: 'Tilburg') == null


// When we use the AutoImplement annotation, only
// methods that are not implemented by ourselves
// will have an auto implementation.
@AutoImplement
class ImplCourseCreator implements Creator&lt;Course&gt; { 
    Course create(Map args) {
        new Course(args)
    }
}

def creator = new ImplCourseCreator()
assert creator.create(name: 'Groovy', location: 'Tilburg') == new Course(name: 'Groovy', location: 'Tilburg')


// Instead of returning the default value for the return type,
// we can throw an exception as default implementation.
// We can specify the type of exception and optionally the
// exception message.
@AutoImplement(exception = UnsupportedOperationException, 
               message = 'Not supported by NotSupportedCourseCreator')
class NotSupportedCourseCreator implements Creator&lt;Course&gt; { }

def creatorUnsupported = new NotSupportedCourseCreator()

def exception = shouldFail(UnsupportedOperationException) {
    creatorUnsupported.create(name: 'Groovy 101')
}
assert exception.message == 'Not supported by NotSupportedCourseCreator'


// We can use the code attribute of the AutoImplement annotation to
// specify a Closure. The Closure is used as implementation for the
// method from the interface.
// In this case we log a warning and return null as value. Notice
// we can access the log variable added by the Log annotation in 
// the Closure of the code attribute.
@groovy.util.logging.Log
@AutoImplement(code = { log.warning('Method needs implementation'); return null })
class ImplementCodeCourseCreator implements Creator&lt;Course&gt; { }

def creatorWarning = new ImplementCodeCourseCreator()
assert !creatorWarning.create(name: 'Groovy') // Prints log message &quot;WARNING: Method needs implementation&quot;
