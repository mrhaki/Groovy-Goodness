// Define regex pattern to find words starting with gr (case-insensitive).
def wordStartsWithGr = ~/(?i)\s+Gr\w+/

assert ('Hello Groovy world!' - wordStartsWithGr) == 'Hello world!'
assert ('Hi Grails users' - wordStartsWithGr) == 'Hi users'


// Remove first match of a word with 5 characters.
assert ('Remove first match of 5 letter word' - ~/\b\w{5}\b/) == 'Remove  match of 5 letter word'


// Remove first found numbers followed by a whitespace character.
assert ('Line contains 20 characters' - ~/\d+\s+/) == 'Line contains characters'
