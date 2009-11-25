import groovy.xml.*

def writer = new StringWriter()
def html = new MarkupBuilder(writer)
html.html {
    head {
        title 'Simple document'
    }
    body(id: 'main') {
        h1 'Building HTML the Groovy Way'
        p {
           mkp.yield 'Mixing text with '
           strong 'bold'
           mkp.yield ' elements.'
        }
        a href: 'more.html', 'Read more...'
    }
}
println writer

/*
Output:
<html>
  <head>
    <title>Simple document</title>
  </head>
  <body id='main'>
    <h1>Building HTML the Groovy Way</h1>
    <p>Mixing text with
      <b>bold</b> elements.
    </p>
    <a href="more.html">Read more..</a>
  </body>
</html>
*/

def builder = new StreamingMarkupBuilder()
builder.encoding = 'UTF-8'
def books = builder.bind {
    mkp.xmlDeclaration()
    namespaces << [meta:'http://meta/book/info']  // Or mkp.declareNamespace('meta':'http://meta/book/info')
    books(count: 3) {
        book(id: 1) {
            title lang:'en', 'Groovy in Action'
            meta.isbn '1-932394-84-2'
        }
        book(id: 2) {
            title lang:'en', 'Groovy Programming' 
            meta.isbn '0123725070'
        }
        book(id: 3) {
            title 'Groovy & Grails'  // & is converted to &amp;
            comment << 'Not yet available.'  // Or mkp.comment('Not yet available')            
        }
        book(id: 4) {
            mkp.yieldUnescaped '<title>Griffon Guide</title>'
        }
    }
}

println XmlUtil.serialize(books)

/* 
Output:
<?xml version="1.0" encoding="UTF-8"?>
<books xmlns:meta="http://meta/book/info" count="3">
  <book id="1">
    <title lang="en">Groovy in Action</title>
    <meta:isbn>1-932394-84-2</meta:isbn>
  </book>
  <book id="2">
    <title lang="en">Groovy Programming</title>
    <meta:isbn>0123725070</meta:isbn>
  </book>
  <book id="3">
    <title>Groovy &amp; Grails</title>
    <!--Not yet available.-->
  </book>
  <book id="4">
    <title>Griffon Guide</title>
  </book>
</books>
*/
