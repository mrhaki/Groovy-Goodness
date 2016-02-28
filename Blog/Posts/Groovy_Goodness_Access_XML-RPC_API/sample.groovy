@Grab('org.codehaus.groovy:groovy-xmlrpc:0.8')
import groovy.net.xmlrpc.*

// Use correct blog identifier.
def blogId = 0 

// Use correct URL for XML-RPC API.
def blogUrl = 'http://blog/xmlrpc' 

def blogUsername = 'mrhaki'
def blogPassword = 'secret'

// Create client access for XML-RPC API.
// The second parameter is set to true
// to autodetect encoding. Default encoding
// is ISO-8859-1.
def wordPress = new XMLRPCServerProxy(blogUrl, true)

// Now we can access the API methods from WordPress.
// Notice the API method wp.getPosts is dynamically
// available from the XMLRPCServerProxy instance.
def latestFivePost = 
    wordPress
        ."wp.getPosts"(
             blogId,
             blogUsername,
             blogPassword,       
             [number: 5, post_type: 'post'],
             ['post_id', 'post_title'])

latestFivePosts.each { post ->
    println "Blog post (#${post.post_id}): ${post.post_title}"
}
