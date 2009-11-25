def xml = '''
<languages>
    <language id="1" jvm="true">Groovy</language>
    <language id="2" jvm="true">Java</language>
    <language id="3" jvm="false">Ruby</language>
</languages>
'''

def languages = new XmlSlurper().parseText(xml)
// Navigate in XML with GPath.
assert 3 == languages.language.size()
assert 'Groovy' == languages.language.find { it.'@id' = 1 }.text()
assert ['Groovy', 'Java', 'Ruby'] == languages.language.collect { it.text() }
assert 1 == languages.language.find { it = /Groovy/ }['@id'].toInteger()

// Navigating with GPath through object graph.
assert 75 == String.metaClass.methods.name.size()
assert ['copyValueOf', 'format', 'valueOf'] == String.metaClass.methods.findAll { it.static }.name.unique()
assert ['replace', 'replace', 'replaceAll', 'replaceFirst'] == String.metaClass.methods.name.grep(~/replace.*/)
assert ['class', 'bytes', 'empty'] == String.metaClass.properties.name
assert ['java.lang.Class', 'byte[]', 'boolean'] == String.metaClass.properties.type.canonicalName
