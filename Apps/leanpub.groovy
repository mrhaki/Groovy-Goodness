import groovy.xml.*
import groovy.text.*

baseDir = '../Leanpub'

def bloggerId = '6671019398434141469'
def baseURI = "https://www.blogger.com/feeds/$bloggerId/posts/default/-/Groovy%3AGoodness" 

def nextLink = baseURI 

while (nextLink) {
    println "Getting posts from $nextLink"
    feed = new XmlSlurper().parse(nextLink)
    feed.entry.each { 
        handleEntry(it) 
    }
    nextLink = feed.link.find { it.@rel == 'next' }.@href.toString() - '/-/Groovy%3AGoodness'
}

def handleEntry(entry) {
    def templateEngine = new GStringTemplateEngine()
    def publishedDate = Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", entry.published.toString())
    def postUrl = entry.link.find { it.@rel == 'alternate' }.@href.toString()
    def postTitle = entry.title.toString() - 'Groovy Goodness: '
    def content = entry.content.toString()
    content = content[0..(content.indexOf('<div class="blogger-post-footer"') - 1)]
    def template = templateEngine.createTemplate(new File('leanpub-template.gtpl'))
                                 .make([content: content, title: postTitle, postUrl: postUrl, publishedDate: publishedDate])
    def filename = entry.link.find { it.@title && it.@rel == 'alternate' }.@href.toString()
    filename = filename[(filename.lastIndexOf("/") + 1)..-1]
    filename = publishedDate.format('yyyyMMdd') + '-' + filename
    def htmlFile = new File(baseDir, filename)
  	htmlFile.withWriter { 
  	    println "Writing contents to $htmlFile.absolutePath"
  		it.write template 
  	}
}

