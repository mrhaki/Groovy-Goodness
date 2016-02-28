import groovy.text.*
import groovy.text.markup.*

// Create configuration for engine.
TemplateConfiguration config = new TemplateConfiguration(
    useDoubleQuotes:true, expandEmptyElements: true)

// Create engine with configuration.
MarkupTemplateEngine engine = new MarkupTemplateEngine(config)     

// Create template with template fragment
// to display the FontAwesome markup.
Template template = engine.createTemplate('''

    // Nested template to generate
    // FontAwesome markup. 
    // The fragment expect a model attribute
    // with the name icon.
    def faIcon = 'span(class: "fa fa-${icon}")'
    
    // Nested template to generate
    // a unordered list for given items,
    // specified with the items model attribute.
    String list = """ul {
        items.each { item -&gt;
            li item
        }
    }
    """
    
    
    // Use fragment method.
    fragment list, items: ['A', 'B', 'C']
    
    
    ul {
        ['cloud', 'home', 'pencil'].each { iconValue ->
            // Generate output with predefined
            // fragment faIcon. Pass value
            // for model attribute icon.
            // We must use ${stringOf{...}} because we apply
            // the fragment as inline element. 
            li "${stringOf {fragment(faIcon, icon: iconValue)}}"
        }
    }
    
    // Reuse fragment in other parts of the template.
    p "This is a ${stringOf {fragment(faIcon, icon: 'cog')}} settings icon."
''')    

// Render output for template.
Writer writer = new StringWriter()                          
Writable output = template.make([:])  
output.writeTo(writer)   
String result = writer.toString()


// This is what we would expect as a result.
def expected = $/\
&lt;ul&gt;&lt;li&gt;A&lt;/li&gt;&lt;li&gt;B&lt;/li&gt;&lt;li&gt;C&lt;/li&gt;&lt;/ul&gt;\
&lt;ul&gt;\
&lt;li&gt;&lt;span class="fa fa-cloud"&gt;&lt;/span&gt;&lt;/li&gt;\
&lt;li&gt;&lt;span class="fa fa-home"&gt;&lt;/span&gt;&lt;/li&gt;\
&lt;li&gt;&lt;span class="fa fa-pencil"&gt;&lt;/span&gt;&lt;/li&gt;\
&lt;/ul&gt;\
&lt;p&gt;This is a &lt;span class="fa fa-cog"&gt;&lt;/span&gt; settings icon.&lt;/p&gt;\
/$

assert result == expected
