import groovy.text.*

// SimpleTemplateEngine.
def simple = new SimpleTemplateEngine()
def source = '''Dear $name,
Please respond to this e-mail before ${(now + 7).format("dd-MM-yyyy")}
Kind regards, mrhaki'''
def binding = [now: new Date(109, 11, 1), name: 'Hubert Klein Ikkink']
def output = simple.createTemplate(source).make(binding).toString()

assert "Dear Hubert Klein Ikkink,\nPlease respond to this e-mail before 08-12-2009\nKind regards, mrhaki" == output

// GStringTemplateEngine with out variable.
def gstring = new GStringTemplateEngine()
def gsource = '''Dear <%= name %>,
Text is created for <% if (gstring) out << 'GStringTemplateEngine' else out << 'other template engine'%>.'''
def gbinding = [name: 'mrhaki', gstring: true]
def goutput = gstring.createTemplate(gsource).make(gbinding).toString()

assert "Dear mrhaki,\nText is created for GStringTemplateEngine." == goutput

// XmlTemplateEngine with gsp:scriplet and gsp:expression tags.
def xmlEngine = new XmlTemplateEngine()
def xml = '''<?xml version="1.0"?>
<users xmlns:gsp='http://groovy.codehaus.org/2005/gsp'>
    <gsp:scriptlet>users.each {</gsp:scriptlet>
        <user id="${it.id}"><gsp:expression>it.name</gsp:expression></user>
    <gsp:scriptlet>}</gsp:scriptlet>
</users>'''
def xmlBinding = [users: [
    new Expando(id: 1, name: 'mrhaki'),
    new Expando(id: 2, name: 'Hubert')]
]
def xmlOutput = xmlEngine.createTemplate(xml).make(xmlBinding).toString()

assert '''\
<users>
  <user id='1'>
    mrhaki
  </user>
  <user id='2'>
    Hubert
  </user>
</users>
''' == xmlOutput
