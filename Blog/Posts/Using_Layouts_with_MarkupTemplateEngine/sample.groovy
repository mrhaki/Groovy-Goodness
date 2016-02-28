// File: LayoutTemplate.groovy
import groovy.text.*
import groovy.text.markup.*

// Create engine with configuration.
TemplateConfiguration config = new TemplateConfiguration()
MarkupTemplateEngine engine = new MarkupTemplateEngine(config)     

// Create template with layout reference
// and values for layout variables.
Template template = engine.createTemplate('''\
layout 'main.tpl', true,
    pageTitle: 'Welcome',
    mainContents: contents {
        h1 'Home'
    },
    actions: contents {
        ul(class: 'actions') {
            ['Home', 'About'].each { li it }
        }
    }
''')    


// Render output for template.
Writer writer = new StringWriter()                          
Writable output = template.make(pubDate: Date.parse('yyyyMMdd', '20140801'))  
//Writable output = template.make([:])  
output.writeTo(writer)   
String result = writer.toString()

// This is what we would expect as a result.
def expected = $/\
&lt;html&gt;&lt;head&gt;&lt;title&gt;Welcome&lt;/title&gt;&lt;/head&gt;\
&lt;body&gt;\
&lt;section id='main'&gt;&lt;h1&gt;Home&lt;/h1&gt;&lt;/section&gt;\
&lt;section id='actions'&gt;&lt;ul&gt;&lt;li&gt;Home&lt;/li&gt;&lt;li&gt;About&lt;/li&gt;&lt;/ul&gt;&lt;/section&gt;\
&lt;footer&gt;&lt;p&gt;Generated on 01-08-2014&lt;/p&gt;&lt;/footer&gt;\
&lt;/body&gt;&lt;/html&gt;\
/$

assert result == expected
