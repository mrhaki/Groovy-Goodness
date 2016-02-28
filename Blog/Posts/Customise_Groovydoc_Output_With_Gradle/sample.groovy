plugins {
    id "groovy"
}

// Here we add a new SourceSet
// that has a resources directory
// at 'src/groovydoc'. This directory
// contains Groovydoc template files
// we want to override for our project.
sourceSets {
    groovydoc {
        resources {
            srcDir 'src/groovydoc'
        }
    }
}

// Customize groovydoc task that is
// added by the Groovy plugin.
groovydoc {
    // Set document and window titles.
    docTitle = "Sample GroovyDoc"
    windowTitle = "Example customizing GroovyDoc"
    
    // Set custom header. We will include this
    // in the changed classDocName.html file.
    header = '''\
        &lt;img src="http://www.mrhaki.com/images/haki-logo-black-64.png"/&gt;
        &lt;h2&gt;Sample project&lt;/h2&gt;
        '''.stripIndent()
    
    // Set custom footer for generated documentation.
    footer = """\
        &lt;div class="custom-footer"&gt;
            Generated on: ${new Date().format('yyyy-MM-dd HH:mm:ss')}
        &lt;/div&gt;""".stripIndent()

    // Change classpath property and include
    // the output of the SourceSet groovydoc.
    // The output contains the changed stylesheet
    // and template file and must be first in the classpath
    // before the files that are bundled with Groovy.
    classpath = sourceSets.groovydoc.output + classpath
}

repositories {
    jcenter()
}

dependencies {
    compile "org.codehaus.groovy:groovy-all:2.4.5"
}
