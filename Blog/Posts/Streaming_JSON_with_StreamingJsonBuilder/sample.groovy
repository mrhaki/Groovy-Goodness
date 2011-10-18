import groovy.json.*

def jsonWriter = new StringWriter()
def jsonBuilder = new StreamingJsonBuilder(jsonWriter)
jsonBuilder.message {
    header {
        from(author: 'mrhaki')  
        to 'Groovy Users', 'Java Users'
    }
    body "Check out Groovy's gr8 JSON support."
}
def json = jsonWriter.toString()
assert json == '{"message":{"header":{"from":{"author":"mrhaki"},"to":["Groovy Users","Java Users"]},"body":"Check out Groovy\'s gr8 JSON support."}}'

def prettyJson = JsonOutput.prettyPrint(json)
assert prettyJson == '''{
    "message": {
        "header": {
            "from": {
                "author": "mrhaki"
            },
            "to": [
                "Groovy Users",
                "Java Users"
            ]
        },
        "body": "Check out Groovy's gr8 JSON support."
    }
}'''


new StringWriter().withWriter { sw ->
    def builder = new StreamingJsonBuilder(sw)

    // Without root element.
    builder name: 'Groovy', supports: 'JSON'

    assert sw.toString() == '{"name":"Groovy","supports":"JSON"}'
}

new StringWriter().with { sw ->
    def builder = new StreamingJsonBuilder(sw)

    // Combine named parameters and closures.
    builder.user(name: 'mrhaki') {
        active true
    }
    
    assert sw.toString() == '{"user":{"name":"mrhaki","active":true}}'    
}
