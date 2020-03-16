import groovy.json.JsonBuilder

// We can use a generator instance as constructor argument
// for JsonBuilder. The generator is used when we create the
// JSON string. It will not effecct the internal JSON data structure.
def jsonBuilder = new JsonBuilder(jsonOutput)
jsonBuilder {
    student new Student('Hubert', 'Klein Ikkink')
    dateOfBirth Date.parse('yyyyMMdd', '19730709')
    website 'https://www.mrhaki.com'.toURL()
    password 'IamSecret'
    awake Optional.empty()
    married Optional.of(true)
    location null
    currency  '\u20AC' 
}

def jsonBuilderResult = jsonBuilder.toString()

assert jsonBuilderResult == '{&quot;student&quot;:&quot;Hubert Klein Ikkink&quot;,' + 
    '&quot;dateOfBirth&quot;:&quot;maandag 09-07-1973&quot;,' + 
    '&quot;awake&quot;:&quot;UNKNOWN&quot;,&quot;married&quot;:true,&quot;currency&quot;:&quot;&euro;&quot;}'

// The internal structure is unaffected by the generator.
assert jsonBuilder.content.password == 'IamSecret'
assert jsonBuilder.content.website.host == 'www.mrhaki.com'


import groovy.json.StreamingJsonBuilder

new StringWriter().withWriter { output -&gt; 

    // As with JsonBuilder we can provide a custom generator via
    // the constructor for StreamingJsonBuilder.
    def jsonStreamingBuilder = new StreamingJsonBuilder(output, jsonOutput)
    jsonStreamingBuilder {
        student new Student('Hubert', 'Klein Ikkink')
        dateOfBirth Date.parse('yyyyMMdd', '19730709')
        website 'https://www.mrhaki.com'.toURL()
        password 'IamSecret'
        awake Optional.empty()
        married Optional.of(true)
        location null
        currency  '\u20AC' 
    }

    def jsonStreamingBuilderResult = output.toString()
    
    assert jsonStreamingBuilderResult == '{&quot;student&quot;:&quot;Hubert Klein Ikkink&quot;,' + 
        '&quot;dateOfBirth&quot;:&quot;maandag 09-07-1973&quot;,' + 
        '&quot;awake&quot;:&quot;UNKNOWN&quot;,&quot;married&quot;:true,&quot;currency&quot;:&quot;&euro;&quot;}'
}
