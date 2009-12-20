def map = [username: 'mrhaki']
assert '[&quot;username&quot;:&quot;mrhaki&quot;]' == map.inspect()

def list = [1, 2, 3, 'Groovy']
assert '[1, 2, 3, &quot;Groovy&quot;]' == list.inspect()

def range = 0..10
assert '0..10' == range.inspect()

def str = 'Inspecting object with Groovy'
assert '&quot;Inspecting object with Groovy&quot;' == str.inspect()

def dom = groovy.xml.DOMBuilder.newInstance().parseText('&lt;root&gt;&lt;language&gt;Groovy&lt;/language&gt;&lt;/root&gt;')
println dom.documentElement.inspect()
// Output:
// &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
// &lt;root&gt;
//   &lt;language&gt;Groovy&lt;/language&gt;
// &lt;/root&gt;
