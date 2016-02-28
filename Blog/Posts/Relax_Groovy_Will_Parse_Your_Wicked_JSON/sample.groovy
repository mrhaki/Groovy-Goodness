import groovy.json.*
import static groovy.json.JsonParserType.LAX as RELAX

def jsonText = '''
{
    message: {
        
        /* Set header of message */
        header: {
            "from": 'mrhaki',
            'to': ["Groovy Users", "Java Users"]
        }
        
        # Include a little body for the message.
        'body': "Check out Groovy's gr8 JSON support."
    }
}       
'''

def json = new JsonSlurper().setType(RELAX).parseText(jsonText)

def header = json.message.header
assert header.from == 'mrhaki'
assert header.to[0] == 'Groovy Users'
assert header.to[1] == 'Java Users'
assert json.message.body == "Check out Groovy's gr8 JSON support."
