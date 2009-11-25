class Author {
    String name
    List books
}
class Book { 
    String title 
}

def createKing() {
    new Author(name: 'Stephen King', books: [
        new Book(title: 'Carrie'),
        new Book(title: 'The Shining'),
        new Book(title: 'It')
    ])
}

assert 3 == createKing().books.size()
assert 'Stephen King' == createKing().name
assert 'Carrie' == createKing().books.getAt(0).title

@Newify 
def createKingRuby() {
    Author.new(name: 'Stephen King', books: [
        Book.new(title: 'Carrie'),
        Book.new(title: 'The Shining'),
        Book.new(title: 'It')
    ])
}

assert 3 == createKingRuby().books.size()
assert 'Stephen King' == createKingRuby().name
assert 'Carrie, The Shining, It' == createKingRuby().books.title.join(', ')

@Newify([Author, Book]) 
def createKingPython() {
    Author(name: 'Stephen King', books: [
        Book(title: 'Carrie'),
        Book(title: 'The Shining'),
        Book(title: 'It')
    ])
}

assert 3 == createKingPython().books.size()
assert 'Stephen King' == createKingPython().name
assert 'It' == createKingPython().books.title.find { it == 'It' }
