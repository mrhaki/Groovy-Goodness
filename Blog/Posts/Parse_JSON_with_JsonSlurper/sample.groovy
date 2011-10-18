import groovy.json.*

def jsonText = '''
{
    "message": {
        "header": {
            "from": "mrhaki",
            "to": ["Groovy Users", "Java Users"]
        },
        "body": "Check out Groovy's gr8 JSON support."
    }
}       
'''

def json = new JsonSlurper().parseText(jsonText)

def header = json.message.header
assert header.from == 'mrhaki'
assert header.to[0] == 'Groovy Users'
assert header.to[1] == 'Java Users'
assert json.message.body == "Check out Groovy's gr8 JSON support."
