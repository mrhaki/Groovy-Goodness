@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.3')
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.client.methods.HttpGet

// HttpClientBuilder.create().build() returns a CloseableHttpClient
// that implements the Closeable interface. Therefore we can use
// the withCloseable method to make sure the client is closed
// after the closure code is executed. 
HttpClientBuilder.create().build().withCloseable { client ->
    final request = new HttpGet('http://www.mrhaki.com')

    // The execute method returns a CloseableHttpResponse object
    // that implements the Closeable interface. We can use
    // withCloseable method to make sure the response is closed
    // after the closure code is executed.
    client.execute(request).withCloseable { response ->
        assert response.statusLine.statusCode == 200
    }
}
