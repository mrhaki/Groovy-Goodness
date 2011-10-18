Nov 14, 2010 11:00:15 PM org.apache.cxf.interceptor.LoggingOutInterceptor$LoggingCallback onClose
INFO: Outbound Message
---------------------------
ID: 1
Address: http://localhost:8080/server/services/blog
Encoding: UTF-8
Content-Type: text/xml
Headers: {SOAPAction=[""], Accept=[*/*]}
Payload: &lt;soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"&gt;&lt;soap:Body&gt;&lt;ns1:findAuthor xmlns:ns1="http://server.groovyws.mrhaki.com"&gt;&lt;in0 xmlns="http://server.groovyws.mrhaki.com"&gt;&lt;authorName&gt;mrhaki&lt;/authorName&gt;&lt;/in0&gt;&lt;/ns1:findAuthor&gt;&lt;/soap:Body&gt;&lt;/soap:Envelope&gt;
--------------------------------------
Nov 14, 2010 11:00:15 PM org.apache.cxf.interceptor.LoggingInInterceptor logging
INFO: Inbound Message
----------------------------
ID: 1
Response-Code: 200
Encoding: UTF-8
Content-Type: text/xml;charset=UTF-8
Headers: {content-type=[text/xml;charset=UTF-8], Date=[Sun, 14 Nov 2010 22:00:15 GMT], transfer-encoding=[chunked], Server=[Apache-Coyote/1.1]}
Payload: &lt;soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"&gt;&lt;soap:Body&gt;&lt;ns1:findAuthorResponse xmlns:ns1="http://server.groovyws.mrhaki.com"&gt;&lt;ns1:out&gt;&lt;blogItems xmlns="http://server.groovyws.mrhaki.com"&gt;&lt;BlogItem&gt;&lt;id&gt;2&lt;/id&gt;&lt;text&gt;Sample blogitem one.&lt;/text&gt;&lt;title&gt;Title1&lt;/title&gt;&lt;version&gt;0&lt;/version&gt;&lt;/BlogItem&gt;&lt;BlogItem&gt;&lt;id&gt;1&lt;/id&gt;&lt;text&gt;Sample blogitem two.&lt;/text&gt;&lt;title&gt;Title2&lt;/title&gt;&lt;version&gt;0&lt;/version&gt;&lt;/BlogItem&gt;&lt;/blogItems&gt;&lt;id xmlns="http://server.groovyws.mrhaki.com"&gt;1&lt;/id&gt;&lt;name xmlns="http://server.groovyws.mrhaki.com"&gt;mrhaki&lt;/name&gt;&lt;version xmlns="http://server.groovyws.mrhaki.com"&gt;0&lt;/version&gt;&lt;/ns1:out&gt;&lt;/ns1:findAuthorResponse&gt;&lt;/soap:Body&gt;&lt;/soap:Envelope&gt;
--------------------------------------
