String s = 'Groovy is gr8!'

assert s.toSet().sort().join() == ' !8Ggiorsvy'
