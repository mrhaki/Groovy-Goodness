def mainDir = new File('test') 
def subDir = new File(mainDir, 'app')
def file = new File(subDir, 'test.txt')

subDir.mkdirs()  // Create directories.
file &lt;&lt; 'sample'  // Create file and add contents.

assert mainDir.exists() &amp;&amp; subDir.exists() &amp;&amp; file.exists()

def result = mainDir.deleteDir()  // Returns true if all goes well, false otherwise.
assert result
assert !mainDir.exists() &amp;&amp; !subDir.exists() &amp;&amp; !file.exists() 
