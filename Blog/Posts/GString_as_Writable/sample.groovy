def data = [
    new Expando(id: 1, user: 'mrhaki', country: 'The Netherlands'),
    new Expando(id: 2, user: 'hubert', country: 'The Netherlands'),
]

data.each { userData -&gt;
    new File("${userData.id}.txt").withWriter('UTF-8') { fileWriter -&gt;
        // Use writeTo method on GString to save
        // result in a file.
        "User $userData.user lives in $userData.country".writeTo(fileWriter)
    }
}


assert new File('1.txt').text == 'User mrhaki lives in The Netherlands'
assert new File('2.txt').text == 'User hubert lives in The Netherlands'
