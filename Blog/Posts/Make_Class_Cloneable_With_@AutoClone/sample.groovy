import groovy.transform.AutoClone
import static groovy.transform.AutoCloneStyle.COPY_CONSTRUCTOR

@AutoClone(style = COPY_CONSTRUCTOR)
class Course {
    final String name
    final Date date
    final Teacher teacher
    
    Course(
        final String name,
        final Date date,
        final Teacher teacher) {
        
        this.name = name
        this.date = date
        this.teacher = teacher
    }
}

@AutoClone(style = COPY_CONSTRUCTOR)
class Teacher {
    final String name
    
    Teacher(final String name) {
        this.name = name
    }
}

def mrhaki =
    new Teacher('mrhaki')
    
def course = 
    new Course(
        'Groovy 101',
        new Date() + 10,
        mrhaki)
        
def secondCourse = course.clone()
assert secondCourse != course
assert !secondCourse.is(course)
assert secondCourse.teacher != mrhaki
assert !secondCourse.teacher.is(mrhaki)
