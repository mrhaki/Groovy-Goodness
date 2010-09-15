import static groovy.io.FileType.*
import static groovy.io.FileVisitResult.*

def groovySrcDir = new File(System.env['GROOVY_HOME'], 'src/')

def countFilesAndDirs = 0
groovySrcDir.traverse {
    countFilesAndDirs++
}
println "Total files and directories in ${groovySrcDir.name}: $countFilesAndDirs"

def totalFileSize = 0
def groovyFileCount = 0
def sumFileSize = { 
    totalFileSize += it.size()
    groovyFileCount++
}
def filterGroovyFiles = ~/.*\.groovy$/
groovySrcDir.traverse type: FILES, visit: sumFileSize, nameFilter: filterGroovyFiles
println "Total file size for $groovyFileCount Groovy source files is: $totalFileSize"

def countSmallFiles = 0
def postDirVisitor = {
    if (countSmallFiles > 0) {
     println "Found $countSmallFiles files with small filenames in ${it.name}"
 }
    countSmallFiles = 0
}
groovySrcDir.traverse(type: FILES, postDir: postDirVisitor, nameFilter: ~/.*\.groovy$/) {
    if (it.name.size() < 15) {
     countSmallFiles++
    }
}
