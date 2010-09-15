class User { String name }
def list = [new Date(), new User(name: 'mrhaki'), 42.0, 'Groovy Rocks!']

assert ['java.util.Date', 'User', 'java.math.BigDecimal', 'java.lang.String'] == list['class']['name']
