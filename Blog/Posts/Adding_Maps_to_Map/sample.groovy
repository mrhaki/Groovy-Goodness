def m = [name: 'Java', max: 10, sort: 'name']
def other = [name: 'Groovy', direction: 'asc']

m << other
assert [name: 'Groovy', max: 10, sort: 'name', direction: 'asc'] == m
