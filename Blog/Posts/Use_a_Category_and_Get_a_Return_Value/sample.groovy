class StringCategory {
    static String groovy(String self) {
        self + ' Yeah man.'
    }
}

def returnedValue = use(StringCategory) {
    def s = 'A simple String.'
    s.groovy()
}

assert 'A simple String. Yeah man.' == returnedValue
