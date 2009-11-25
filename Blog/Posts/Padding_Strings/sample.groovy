assert '   Groovy   ' == 'Groovy'.center(12)
assert 'Groovy      ' == "Groovy".padRight(12)
assert '      Groovy' == /Groovy/.padLeft(12)

assert '---Groovy---' == "Groovy".center(12, '-')
assert 'Groovy * * *' == "Groovy".padRight(12, ' *')
assert 'Groovy Groovy Groovy' == 'Groovy'.padLeft(20, 'Groovy ')

def createOutput = {
    def table = [
        // Page,    Response time, Size
        ['page1.html',        200, 1201],
        ['page2.html',         42, 8853],
        ['page3.html',         98, 3432],
        ['page4.html',        432, 9081]
    ]

    def total = { data, index ->
        data.inject(0) { result, row -> result += row[index] }
    }
    def totalTime = total.curry(table, 1)
    def totalSize = total.curry(table, 2)

    def out = new StringBuffer()
    out << ' Summary '.center(15, "*") << '\n\n'
    out << 'Total pages:'.padRight(25)
    out << table.size().toString().padLeft(6) << '\n'
    out << 'Total response time (ms):'.padRight(25)
    out << totalTime().toString().padLeft(6) << '\n'
    out << 'Total size (KB):'.padRight(25)
    out << totalSize().toString().padLeft(6) << '\n\n'

    out << ' Details '.center(15, "*") << '\n\n'
    table.each {
        out << it[0].padRight(14)
        out << it[1].toString().padLeft(5)
        out << it[2].toString().padLeft(8)
        out << '\n'
    }
    out.toString()
}

assert '''\
*** Summary ***

Total pages:                  4
Total response time (ms):   772
Total size (KB):          22567

*** Details ***

page1.html      200    1201
page2.html       42    8853
page3.html       98    3432
page4.html      432    9081
''' == createOutput()
