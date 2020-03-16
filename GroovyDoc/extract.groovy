import groovy.transform.Field
import groovy.json.JsonSlurper

//@Field
String apiKey = 'AIzaSyC6j8C86TvtSjaTPtzED2byly0s93xHvX4'

String blogApiUrl = 'https://www.googleapis.com/blogger/v3/blogs/6671019398434141469/posts/bypath'

Map parameters = [:]
parameters.key = apiKey

parameters.field = 'content'

String urlValue = args[0]
URL url = urlValue.toURL()
String path = url.path

parameters.path = path

String urlParams = parameters.collect().join('&')

URL blogUrl = new URL("$blogApiUrl?$urlParams")

println blogUrl

def jsonSlurper = new JsonSlurper()
def post = jsonSlurper.parse(blogUrl)

String content = "<div>$post.content</div>"

//println content

def blogSlurper = new XmlSlurper().parseText(content)
def codes = blogSlurper.pre

codes.each { codeBlock ->
    String codeHtml =
        codeBlock.text()
            .replaceAll('<', '&lt;')
            .replaceAll('>', '&gt;')
            .replaceAll('@', '&#64;')

    println '-' * 80
    println " * <pre>"
    if (codes.size() > 1) {
        print ' * //'
        println '-' * 74
    }
    codeHtml.eachLine { line ->
        print ' * '
        println line
    }
    println " * </pre>"
}
