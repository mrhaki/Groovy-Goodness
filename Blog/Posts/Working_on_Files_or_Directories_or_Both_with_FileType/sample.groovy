import groovy.io.FileType

// First create sample dirs and files.
(1..3).each { 
 new File("dir$it").mkdir() 
}
(1..3).each { 
 def file = new File("file$it")
 file << "Sample content for ${file.absolutePath}"
}

def currentDir = new File('.')
def dirs = []
currentDir.eachFile FileType.DIRECTORIES, {
    dirs << it.name
}
assert 'dir1,dir2,dir3' == dirs.join(',')

def files = []
currentDir.eachFile(FileType.FILES) {
    files << it.name
}
assert 'file1,file2,file3' == files.join(',')

def found = []
currentDir.eachFileMatch(FileType.ANY, ~/.*2/) {
   found << it.name
}

assert 'dir2,file2' == found.join(',')
