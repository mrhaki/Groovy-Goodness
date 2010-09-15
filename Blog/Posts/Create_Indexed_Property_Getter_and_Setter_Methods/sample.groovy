import groovy.transform.IndexedProperty

class Group {
    String name
    List members = []
}

class IndexedGroup {
    String name
    @IndexedProperty List members = []
}

def group = new Group(name: 'Groovy')
group.members[0] = 'mrhaki'
group.members[1] = 'Hubert'
assert 2 == group.members.size()
assert ['mrhaki', 'Hubert'] == group.members

try {
    group.setMembers(0, 'hubert') // Not index property
} catch (MissingMethodException e) {
    assert e
}

def indexedGroup = new IndexedGroup(name: 'Grails')
indexedGroup.members[0] = 'mrhaki'
indexedGroup.setMembers 1, 'Hubert'
assert 2 == indexedGroup.members.size()
assert 'mrhaki' == indexedGroup.getMembers(0)
assert 'Hubert' == indexedGroup.members[1]
