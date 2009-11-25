import org.apache.commons.lang.SystemUtils

@Grab(group='commons-lang', module='commons-lang', version='2.4')
def printInfo() {
    if (SystemUtils.isJavaVersionAtLeast(5)) {
        println 'We are ready to use annotations in our Groovy code.'
    } else {
        println 'We cannot use annotations in our Groovy code.'
    }
}

printInfo()
