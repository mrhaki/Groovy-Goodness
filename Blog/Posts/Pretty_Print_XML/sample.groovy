import groovy.xml.*

// Get groovy.util.Node value.
def xmlString = '&lt;languages&gt;&lt;language id="1"&gt;Groovy&lt;/language&gt;&lt;language id="2"&gt;Java&lt;/language&gt;&lt;language id="3"&gt;Scala&lt;/language&gt;&lt;/languages&gt;'
Node languages = new XmlParser().parseText(xmlString)


// Create output with all default settings.
def xmlOutput = new StringWriter()
def xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput))
xmlNodePrinter.print(languages)

assert xmlOutput.toString() == '''\
&lt;languages&gt;
  &lt;language id="1"&gt;
    Groovy
  &lt;/language&gt;
  &lt;language id="2"&gt;
    Java
  &lt;/language&gt;
  &lt;language id="3"&gt;
    Scala
  &lt;/language&gt;
&lt;/languages&gt;
'''


// Create output and set indent character
// one space.
// (can also by \t for tabs, or other characters)
xmlOutput = new StringWriter()
xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput), " " /* indent */)
xmlNodePrinter.print(languages)

assert xmlOutput.toString() == '''\
&lt;languages&gt;
 &lt;language id="1"&gt;
  Groovy
 &lt;/language&gt;
 &lt;language id="2"&gt;
  Java
 &lt;/language&gt;
 &lt;language id="3"&gt;
  Scala
 &lt;/language&gt;
&lt;/languages&gt;
'''


// Use properties preserveWhitespace,
// expandEmptyElements and quote to
// change the formatting.
xmlOutput = new StringWriter()
xmlNodePrinter = new XmlNodePrinter(new PrintWriter(xmlOutput))
xmlNodePrinter.with {
    preserveWhitespace = true
    expandEmptyElements = true
    quote = "'" // Use single quote for attributes
}
xmlNodePrinter.print(languages)

assert xmlOutput.toString() == """\
&lt;languages&gt;
  &lt;language id='1'&gt;Groovy&lt;/language&gt;
  &lt;language id='2'&gt;Java&lt;/language&gt;
  &lt;language id='3'&gt;Scala&lt;/language&gt;
&lt;/languages&gt;
"""
