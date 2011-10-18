class User implements Comparable {
    String username, email
    boolean active
    
    int compareTo(Object other) {
        username <=> other.username
    }
    
    String toString() { "[User:$username,$email,$active]" }
}

def mrhaki1 = new User(username: 'mrhaki', email: 'mrhaki@localhost', active: false)
def mrhaki2 = new User(username: 'mrhaki', email: 'user@localhost', active: true)

def hubert1 = new User(username: 'hubert', email: 'user@localhost', active: false)
def hubert2 = new User(username: 'hubert', email: 'hubert@localhost', active: true)

def users = [mrhaki1, mrhaki2, hubert1, hubert2]


/* Sort */
def sortedUsers = users.sort(mutate = false)  // Don't mutate original List
assert sortedUsers == [hubert1, hubert2, mrhaki1, mrhaki2]
assert users == [mrhaki1, mrhaki2, hubert1, hubert2]

// Default behaviour is to change original collection
sortedUsers = users.sort() 
assert sortedUsers == [hubert1, hubert2, mrhaki1, mrhaki2]
assert users == [hubert1, hubert2, mrhaki1, mrhaki2]


/* Unique */
def uniqueUsers = users.unique(mutate = false)  // Don't mutate original List
assert uniqueUsers == [hubert1, mrhaki1]
assert users == [hubert1, hubert2, mrhaki1, mrhaki2]

// Default behaviour is to change original collection
uniqueUsers = users.unique()   
assert uniqueUsers == [hubert1, mrhaki1]
assert users == [hubert1, mrhaki1]


/* Reverse */
def reverseUsers = users.reverse()  // mutate false is default
assert reverseUsers == [mrhaki1, hubert1]
assert users == [hubert1, mrhaki1]

// Default behaviour is to leave original collection alone
reverseUsers = users.reverse(mutate = true)  // Mutate original list
assert reverseUsers == [mrhaki1, hubert1]
assert users == [mrhaki1, hubert1]
