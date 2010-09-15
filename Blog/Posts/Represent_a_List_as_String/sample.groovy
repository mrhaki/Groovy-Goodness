def list = ['Groovy', 'Clojure', 'Java']

def listString = list.toListString()
def abbreviated = list.toListString(12)

assert '[Groovy, Clojure, Java]' == listString
assert '[Groovy, Clojure, ...]' == abbreviated
