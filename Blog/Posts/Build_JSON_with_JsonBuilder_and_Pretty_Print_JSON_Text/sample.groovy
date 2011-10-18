import groovy.json.*

def json = new JsonBuilder()

json.message {
    header {
        from('mrhaki')  // parenthesis are optional
        to 'Groovy Users', 'Java Users'
    }
    body "Check out Groovy's gr8 JSON support."
}

assert json.toString() == '{"message":{"header":{"from":"mrhaki","to":["Groovy Users","Java Users"]},"body":"Check out Groovy\'s gr8 JSON support."}}'

// We can even pretty print the JSON output
def prettyJson = JsonOutput.prettyPrint(json.toString())
assert prettyJson == '''{
    "message": {
        "header": {
            "from": "mrhaki",
            "to": [
                "Groovy Users",
                "Java Users"
            ]
        },
        "body": "Check out Groovy's gr8 JSON support."
    }
}'''
