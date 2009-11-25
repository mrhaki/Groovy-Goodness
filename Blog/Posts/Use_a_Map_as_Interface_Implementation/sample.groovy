map = [ 
    // Implement FileFilter.accept(File) method.
    accept: { file -> file.path ==~ /.*\.(css|png)$/ } 
] as FileFilter
new File('c:/temp').listFiles(map).each { 
    println it.path 
}

filter = { it.path ==~ /.*\.jpg$/ }
new File('c:/temp').listFiles(filter as FileFilter).each { file ->
    println file.path
}
