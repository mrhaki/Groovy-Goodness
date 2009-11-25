import static HttpURLConnection.HTTP_OK  // Normal Java static import.
import static HttpURLConnection.HTTP_OK as okay 
import static HttpURLConnection.setFollowRedirects as redirect
import java.net.HttpURLConnection as http // Non static import.

redirect false  // HttpURLConnection.setFollowRedirects(false)
assert false == HttpURLConnection.followRedirects

def c = (http) 'http://mrhaki.blogspot.com'.toURL().openConnection()
assert c instanceof HttpURLConnection

assert okay == c.responseCode
assert HTTP_OK == c.responseCode
