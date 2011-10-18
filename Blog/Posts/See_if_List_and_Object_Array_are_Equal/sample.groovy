def numbers1 = [1,2,3] as int[]
def numbers2 = [1,2,3] as int[]
def numbers3 = [1,2] as int[]

assert numbers1.equals(numbers2)
assert numbers2 == numbers1
assert !(numbers1.equals(numbers3))

def list = ['Groovy', 'Grails', 'Gradle']
def stringArray1 = ['Grails', 'Gradle', 'Groovy'] as Object[]
def stringArray2 = ['Groovy', 'Grails', 'Gradle'] as Object[]

assert list.equals(stringArray2)
assert list == stringArray2
assert !(list.equals(stringArray1)) // order matters
assert list != stringArray1
