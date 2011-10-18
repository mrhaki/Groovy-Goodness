def date = {
    def d = new Date()
    d.set year: 2010, month: Calendar.DECEMBER, date: 1
    d.format "dd-MM-yyyy"
}()

assert date == '01-12-2010'

def text = {
    def result = ''
    "mrhaki".size().times {
        result += it
    }
    result
}.call()

assert text == '012345'
