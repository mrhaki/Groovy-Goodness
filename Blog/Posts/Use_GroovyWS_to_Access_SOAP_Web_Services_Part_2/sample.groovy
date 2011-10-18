package com.mrhaki.groovyws.client

import spock.lang.Specification

class BlogWSClientSpec extends Specification {

    def client = new BlogWSClient(wsdlUrl: 'http://localhost:8080/server/services/blog?wsdl')

    def "get author with name mrhaki and two blog items"() {
        when:
        def author = client.findAuthor('mrhaki')

        then:
        'mrhaki' == author.name
        def arrayOfBlogItems = author.blogItems
        def blogItems = arrayOfBlogItems.blogItem
        2 == blogItems.size()
        'Title1' == blogItems[0].title
        'Title2' == blogItems[1].title
        'Sample blogitem one.' == blogItems[0].text
        'Sample blogitem two.' == blogItems[1].text
    }

}
