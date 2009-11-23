// Suppose we have a environment variable GROOVY_HOME pointing to the Groovy installation dir.
def groovyHome = System.getenv('GROOVY_HOME')

// Find files with ANT style patterns.
def txtFiles = new FileNameFinder().getFileNames(groovyHome, '**/*.txt' /* includes */, '**/*.doc **/*.pdf' /* excludes */)
assert new File(groovyHome, 'README.txt').absolutePath in txtFiles

// Find files with regular expressions.
def icoFiles = new FileNameByRegexFinder(groovyHome, /.*\.ico$/)
assert new File(groovyHome, 'html/groovy-jdk/groovy.ico').absolutePath in icoFiles