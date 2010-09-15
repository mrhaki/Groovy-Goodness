def s = 'one two three four'

def resultList = s.tokenize()
assert resultList.class.name == 'java.util.ArrayList'
assert ['one', 'two', 'three', 'four'] == resultList

def resultArray = s.split()
assert resultArray instanceof String[]
assert ['one', 'two', 'three', 'four'] == resultArray

def s1 = 'Java:Groovy'
assert ['Java', 'Groovy'] == s1.tokenize(":")
assert ['Java', 'Groovy'] == s1.tokenize(':' as char)
