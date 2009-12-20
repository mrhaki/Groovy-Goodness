import groovy.xml.*
import groovy.xml.dom.*

def xml = '''
&lt;users&gt;
    &lt;user active=&quot;true&quot;&gt;
        &lt;fullname&gt;mrhaki&lt;/fullname&gt;
    &lt;/user&gt;
    &lt;user active=&quot;false&quot;&gt;
        &lt;fullname&gt;Hubert A. Klein Ikkink&lt;/fullname&gt;
    &lt;/user&gt;
&lt;/users&gt;
'''
def xmlDom = DOMBuilder.newInstance().parseText(xml)  // Create DOM structure.

def root = xmlDom.documentElement
use (DOMCategory) {
    def users = root.user
    assert 2 == users.size()
    
    assert 'User with fullname mrhaki is active' == userInfo(users[0])
    assert 'User with fullname Hubert A. Klein Ikkink is not active' == userInfo(users[1])

    assert 'mrhaki' == users.findAll { it.'@active'.toBoolean() }[0].fullname.text()
}

def userInfo(user) {
    def active = user.'@active'.toBoolean()
    def fullname = user.fullname.text()
    &quot;User with fullname $fullname is ${active ? 'active' : 'not active'}&quot;
}
