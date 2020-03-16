// We can even use a shorter syntax with the
// FileTreeBuilder where the node names are the name
// of a directory to be created (argument is a closure),
// or the name of a file and some contents.
// Notice that with the DSL all file contents is
// appended to existing file contents.
// We need to delete an existing file first if we
// don't want to append the contents.

final File newDir = new File('dsl')

// Remove existing dir, so file contents is
// only set by the FileTreeBuilder DSL,
// otherwise content is added to the existing files.
if (newDir.exists()) {
    newDir.deleteDir()
}

newDir.mkdirs()
final FileTreeBuilder dir = new FileTreeBuilder(newDir)

dir {
    // Node name is the file name, followed by the contents.
    'README.adoc'('''\
        = Groovy rocks!

        Hidden features in Groovy are also cool.

        '''.stripIndent())

    'README.adoc'('== Extra heading')

     // We cannot use a closure argument with this DSL,
     // like with the builder. The DSL assume that a node with a
     // closure is a directory.
     // But we can use the File object argument to set
     // the file contents.
    'README1.adoc'(sample)
}

// If name is follwed by closure than a directory
// name is assumed and created.
dir.out {}

// Created directory with subdirectories.
dir.src {
    // The name of the node is the directory name.
    docs {
        // And create file in the src/docs directory.
        'manuscript.adoc'('= Building Apps With Grails 3')
    }
}

assert new File('dsl/README.adoc').exists()
assert new File('dsl/src/docs/manuscript.adoc').exists()
assert new File('dsl/src/docs/manuscript.adoc').text == '= Building Apps With Grails 3'
