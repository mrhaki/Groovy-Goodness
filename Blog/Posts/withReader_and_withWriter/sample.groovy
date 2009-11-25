def file = new File('sample.txt')

file.withWriter('UTF-8') {
    it.writeLine 'Adding this text to the file.'
}

def s 
file.withReader('UTF-8') {
    s = it.readLine()
}

assert 'Adding this text to the file.' == s
