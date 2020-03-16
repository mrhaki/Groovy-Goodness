def scriptText = '''
def s = "Groovy rocks!"

// Print value of s.
println s

// Use printf for formatted printing.
printf 'The answer is %X', 42
'''

def shell = new GroovyShell()

// Parse script text and return Script object.
def script = shell.parse(scriptText)

// Assign new PrintWriter to "out"
// variable of Script class.
def stringWriter = new StringWriter()
script.out = new PrintWriter(stringWriter)

// Run the script.
script.run()

// Check the output of print, println and printf methods.
assert stringWriter.toString() == 'Groovy rocks!\nThe answer is 2A'
