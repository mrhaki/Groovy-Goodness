String.metaClass {
    or &lt;&lt; { String s -&gt; delegate.plus(' or ').plus(s) }
    or &lt;&lt; { List l -&gt; delegate.findAll(&quot;(${l.join('|')})&quot;) }
    and { String s -&gt; delegate.plus(' and ').plus(s) }
    'static' {
        groovy { 'Yeah man!' }
    }
}

assert 'Groovy or Java?' == (&quot;Groovy&quot; | &quot;Java?&quot;)
assert ['o', 'o', 'y'] == (&quot;Groovy&quot; | ['o', 'y'])
assert 'Groovy and Java!' == (&quot;Groovy&quot; &amp; &quot;Java!&quot;)

assert 'Yeah man!' == String.groovy()
