def list = ['Java', 'Groovy', 'Scala']

def index = 0
def indices = [0,2]
def range = (1..-1)

assert 'Java' == list[index]
assert ['Java', 'Scala'] == list[indices]
assert ['Groovy', 'Scala'] == list[range]
