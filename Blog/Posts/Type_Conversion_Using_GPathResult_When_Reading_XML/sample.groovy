def xml = '''
&lt;users&gt;
    &lt;user loggedin=&quot;true&quot;&gt;
        &lt;age&gt;36&lt;/age&gt;
        &lt;name&gt;mrhaki&lt;/name&gt;
        &lt;fullname&gt;Hubert A. Klein Ikkink&lt;/fullname&gt;
        &lt;homepage&gt;http://www.mrhaki.com/&lt;/homepage&gt;
    &lt;/user&gt;
&lt;/users&gt;
'''

def users = new XmlSlurper().parseText(xml)
def mrhaki = users.user[0]
assert mrhaki.@loggedin.toBoolean() 
assert 36 == mrhaki.age.toInteger()
assert 'mrhaki' == mrhaki.name.toString()
assert new URL('http://www.mrhaki.com/') == mrhaki.homepage.toURL()
