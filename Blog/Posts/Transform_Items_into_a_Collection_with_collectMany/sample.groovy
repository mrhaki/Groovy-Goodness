def text = 'groovy' as String[]

def mixedCase = text.collectMany { [it, it.toUpperCase()] }
assert mixedCase == ['g','G','r','R','o','O','o','O','v','V','y','Y']
assert text == 'groovy' as String[]


def list = [12, 20, 34]
def result = list.collectMany { [it, it*2, it*3] }

assert result == [12,24,36,20,40,60,34,68,102]
assert list == [12, 20, 34]
