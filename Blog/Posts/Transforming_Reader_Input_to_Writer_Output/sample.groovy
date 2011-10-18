def reader = new StringReader('''\
Groovy's support
for transforming reader input to writer output.
''')

def writer = new StringWriter()

reader.transformLine(writer) { line -&gt;  
    if (line.matches(~/^Groovy.*/)) {
        line = '&gt;&gt;' + line.replaceAll('Groovy', 'GROOVY') + '&lt;&lt; '
    }
    line
}

def resultTransformLine = writer.toString()

reader = new StringReader(resultTransformLine)
writer = new StringWriter()
reader.transformChar(writer) { ch -&gt;
    ch in ['\n', '\r'] ? '' : ch
}

assert writer.toString() == "&gt;&gt;GROOVY's support&lt;&lt; for transforming reader input to writer output."
