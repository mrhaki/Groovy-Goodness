String.metaClass.groovy &lt;&lt; { Integer number -&gt;
    delegate * number
} &lt;&lt; { String s -&gt;
    delegate + s
} &lt;&lt; { -&gt;
    delegate + ' Groovy rocks.'
}

assert 'GroovyGroovy' == 'Groovy'.groovy(2)
assert 'Hello world from Groovy' == 'Hello world'.groovy(' from Groovy')
assert 'It is true. Groovy rocks.' == 'It is true.'.groovy()
