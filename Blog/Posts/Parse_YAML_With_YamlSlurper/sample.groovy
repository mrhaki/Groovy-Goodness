def multiDocYaml = '''\
---
version: 1
--- 
loadAtStartup: true
'''

// For YAML with multiple documents separated by ---
// we first need to remove the separators, otherwise
// only the first document is parsed.
def multiDoc = new YamlSlurper().parseText(multiDocYaml.replaceAll('---', ''))

assert multiDoc.version == 1
assert multiDoc.loadAtStartup
