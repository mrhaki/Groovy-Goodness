class Person implements Comparable {
    String username
    String email

    int compareTo(other) {
        this.username <=> other.username
    }
}

assert -1 == ('a' <=> 'b')
assert 0 == (42 <=> 42)
assert -1 == (new Person([username:'mrhaki', email: 'test@email.com']) <=> new Person([username:'zavaria', email:'tester@email.com']))
assert [1, 2, 3, 4] == [4, 2, 1, 3].sort{ a, b -> a <=> b }
