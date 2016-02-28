Writable make(Map binding = [:], Closure template) {
    // Use asWritable() to make the closure
    // implement the Writable interface.
    def writableTemplate = template.asWritable()
    
    // Assing binding map as delegate so we can access
    // the keys of the maps as properties in the 
    // closure context.
    writableTemplate.delegate = binding
    
    // Return closure as Writable.
    writableTemplate
}

// Use toString() of Writable closure.
assert make { Writer out -&gt; out &lt;&lt;  "Hello world!" }.toString() == 'Hello world!'

// Provide data for the binding.
// The closure is not executed when the 
// make method is finished.
final writable = make(user:'mrhaki', { out -&gt;
    out.println "Welcome ${user},"
    out.print "Today on ${new Date(year: 114, month: 3, date: 4).format('dd-MM-yyyy')}, "
    out.println "we have a Groovy party!"
})

// We invoke toString() and now the closure
// is executed.
final result = writable.toString()

assert result == '''Welcome mrhaki,
Today on 04-04-2014, we have a Groovy party!
'''

// Append contents to a file.
// NOTE: The leftShift (&lt;&lt;) operator on File is implemented
// in Groovy to use the File.append() method.
// The append() method creates a new Writer and
// invokes the write() method which 
// is re-implemented in Groovy if the argument
// is a Writable object. Then the writeTo() method
// is invoked:
// Writer.write(Writable) becomes Writable.writeTo(Writer).
// So a lot of Groovy magic allows us to use the following one-liner
// and still the writeTo() method is used on Writable.
new File('welcome.txt') &lt;&lt; writable

assert new File('welcome.txt').text == '''Welcome mrhaki,
Today on 04-04-2014, we have a Groovy party!
'''
