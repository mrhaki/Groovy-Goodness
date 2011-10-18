// File: RunScript.groovy
// Run with groovy -cp . RunScript
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.CompilerConfiguration

// Add imports for script.
def importCustomizer = new ImportCustomizer()
// import static com.mrhaki.blog.Type.*
importCustomizer.addStaticStars 'com.mrhaki.blog.Type'
// import com.mrhaki.blog.Post as Article
importCustomizer.addImport 'Article', 'com.mrhaki.blog.Post'

def configuration = new CompilerConfiguration()
configuration.addCompilationCustomizers(importCustomizer)

// Create shell and execute script.
def shell = new GroovyShell(configuration)
shell.evaluate new File('sample.groovy')
