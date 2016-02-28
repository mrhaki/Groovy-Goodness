def saying = ['Groovy', 'is', 'great']

def yodaSays = saying.swap(2, 1).swap(0, 1)

assert yodaSays.join(' ') == 'great Groovy is'
