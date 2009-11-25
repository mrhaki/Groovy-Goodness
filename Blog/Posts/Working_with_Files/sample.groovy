// Normal way of creating file objects.
def file1 = new File('groovy1.txt')
def file2 = new File('groovy2.txt')
def file3 = new File('groovy3.txt')

// Writing to the files with the write method:
file1.write 'Working with files the Groovy way is easy.\n'

// Using the leftShift operator:
file1 << 'See how easy it is to add text to a file.\n'

// Using the text property:
file2.text = '''We can even use the text property of
a file to set a complete block of text at once.'''

// Or a writer object:
file3.withWriter('UTF-8') { writer ->
    writer.write('We can also use writers to add contents.')
}

// Reading contents of files to an array:
def lines = file1.readLines()
assert 2 == lines.size()
assert 'Working with files the Groovy way is easy.' == lines[0]

// Or we read with the text property:
assert 'We can also use writers to add contents.' == file3.text

// Or with a reader:
count = 0
file2.withReader { reader -> 
    while (line = reader.readLine()) {
        switch (count) {
            case 0: 
                assert 'We can even use the text property of' == line
                break
            case 1:
                assert 'a file to set a complete block of text at once.' == line
                break
        }
        count++
    }
}

// We can also read contents with a filter:
sw = new StringWriter()
file1.filterLine(sw) { it =~ /Groovy/ }
assert 'Working with files the Groovy way is easy.\r\n' == sw.toString()

// We can look for files in the directory with different methods.
// See for a complete list the File GDK documentation.
files = []
new File('.').eachFileMatch(~/^groovy.*\.txt$/) { files << it.name }
assert ['groovy1.txt', 'groovy2.txt', groovy3.txt'] == files

// Delete all files:
files.each { new File(it).delete() }
