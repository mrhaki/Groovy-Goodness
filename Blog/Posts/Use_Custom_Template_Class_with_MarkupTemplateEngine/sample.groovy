import com.mrhaki.groovy.tmpl.*
import groovy.text.*
import groovy.text.markup.*


// Create configuration and set 
// base template class to
// FontAwesomeTemplate.
TemplateConfiguration config = new TemplateConfiguration(
    baseTemplateClass: FontAwesomeTemplate
)

// Create engine with configuration.
MarkupTemplateEngine engine = new MarkupTemplateEngine(config)     

// Create template with text using
// the icon method.
Template template = engine.createTemplate('''
    ul {
        // Use the name of the icon as argument
        // for the icon method.
        li icon('cloud')

        // Any extra arguments are assumed
        // to be FontAwesome attributes.
        li icon('pencil', 'large', 'rotate-90')
    }

    // If we want to use the icon method in between
    // text we must use the ${stringOf notation}.
    p "This is a ${stringOf {icon('home')}} home icon."

    // Or use yieldUnescaped method.
    p {
        yield "This is a "
        yieldUnescaped icon('cog')
        yield " settings icon."
    }

''')    

// Render output for template.
Writer writer = new StringWriter()                          
Writable output = template.make([:])  
output.writeTo(writer)   
String result = writer.toString()


// This is what we would expect as a result.
// (/ is the continuation character, so it is 
//  actually all one line)
def expected = $/\
&lt;ul&gt;\
&lt;li&gt;&lt;span class="fa fa-cloud "&gt;&lt;/span&gt;&lt;/li&gt;\
&lt;li&gt;&lt;span class="fa fa-pencil fa-large fa-rotate-90"&gt;&lt;/span&gt;&lt;/li&gt;\
&lt;/ul&gt;\
&lt;p&gt;This is a &lt;span class="fa fa-home "&gt;&lt;/span&gt; home icon.&lt;/p&gt;\
&lt;p&gt;This is a &lt;span class="fa fa-cog "&gt;&lt;/span&gt; settings icon.&lt;/p&gt;\
/$

assert result == expected
