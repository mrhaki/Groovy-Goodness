class User implements Comparable {
    String username, email
    boolean active
    
    int compareTo(Object other) {
        username &lt;=&gt; other.username
    }
}

def mrhaki1 = new User(username: 'mrhaki', email: 'mrhaki@localhost', active: false)
def mrhaki2 = new User(username: 'mrhaki', email: 'user@localhost', active: true)
def hubert1 = new User(username: 'hubert', email: 'user@localhost', active: false)
def hubert2 = new User(username: 'hubert', email: 'hubert@localhost', active: true)

// Caution: unique() changes the original collection, so 
// for the sample we invoke unique each time on a fresh new
// user list.
def uniqueUsers = [mrhaki1, mrhaki2, hubert1, hubert2].unique()
assert 2 == uniqueUsers.size()
assert [mrhaki1, hubert1] == uniqueUsers

// Use closure with one parameter.
def uniqueEmail = [mrhaki1, mrhaki2, hubert1, hubert2].unique { user -&gt; 
    user.email 
}
assert 3 == uniqueEmail.size()
assert [mrhaki1, mrhaki2, hubert2] == uniqueEmail

// Use closure with two parameters.
def uniqueActive = [mrhaki1, mrhaki2, hubert1, hubert2].unique { user1, user2 -&gt;
    user1.active &lt;=&gt; user2.active
}
assert 2 == uniqueActive.size()
assert [mrhaki1, mrhaki2] == uniqueActive

// Use a comparator.
def emailComparator = [
    equals: { delegate.equals(it) },
    compare: { first, second -&gt;
        first.email &lt;=&gt; second.email
    }
] as Comparator
def unique = [mrhaki1, mrhaki2, hubert1, hubert2].unique(emailComparator)
assert 3 == unique.size()
assert [mrhaki1, mrhaki2, hubert2] == unique
?
