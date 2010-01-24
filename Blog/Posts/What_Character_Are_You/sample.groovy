def str = 'a1cB \n.9'
def characters = str.chars  // Convert to char[]

assert characters[0].isLetter()  // 'a'
assert characters[1].isDigit()  // '1'
assert characters[2].isLowerCase()  // 'c'
assert characters[3].isUpperCase()  // 'B'
assert characters[4].isWhitespace()  // ' '
assert characters[5].isWhitespace()  // '\n'
assert !characters[6].isLetterOrDigit()  // '.'
assert characters[7].isLetterOrDigit()  // '9'
