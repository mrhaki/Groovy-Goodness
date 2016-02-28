import java.nio.file.*

final Path newFile = Paths.get('output.txt')
if (Files.exists(newFile)) {
    Files.delete(newFile)
}

// Different ways to add content.
newFile.write 'START'
newFile.write System.getProperty('line.separator')
newFile << 'Just a line of text'
newFile.withWriterAppend { writer -&gt;
    writer.println()
    writer.println 'END'
}


// Read contents.
final Path readFile = Paths.get('output.txt')

assert readFile.readLines().join(';') == 'START;Just a line of text;END'
assert readFile.filterLine { it.contains('text') }.toString().normalize() == 'Just a line of text\n'


// Work with Path objects,
// like with File GDK extensions with
// eachFile, eachDir, eachFileRecursive...
final Path root = Paths.get('.')
def paths = root.eachFileMatch(~/.*\.txt$/) {
    assert it.toFile().name == 'output.txt'
}
