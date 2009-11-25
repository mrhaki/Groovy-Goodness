def abc = ['a', 'b', 'c']
assert 'abc' == abc.join()
assert 'a::b::c' == abc.join('::')

def numbers = [0, 1, 2, 3, 4, 5] as Integer[]
assert '012345' == numbers.join()
assert '0 x 1 x 2 x 3 x 4 x 5' == numbers.join(' x ')
assert '0 1 2 3 4 5' == numbers.join(' ')

def objects = [new URL('http://www.mrhaki.com'), 'mrhaki', new Expando(name: 'mrhaki'), new Date(109, 10, 10)]
assert 'http://www.mrhaki.com,mrhaki,{name=mrhaki},Tue Nov 10 00:00:00 UTC 2009' == objects.join(',')

// Also great for creating URL query parameters.
def map = [q: 'groovy', maxResult: 10, start: 0, format: 'xml']
def params = map.inject([]) { result, entry -> 
    result << "${entry.key}=${URLEncoder.encode(entry.value.toString())}"
}.join('&')
assert 'q=groovy&maxResult=10&start=0&format=xml' == params
