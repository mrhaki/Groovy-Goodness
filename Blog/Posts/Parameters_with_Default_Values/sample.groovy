def say(msg = 'Hello', name = 'world') {
    "$msg $name!"
}

// We can invoke 3 signatures:
// say(), say(msg), say(msg, name)
assert 'Hello world!' == say()
// Right most parameter with default value is eliminated first.
assert 'Hi world!' == say('Hi')
assert 'Howdy, mrhaki!' == say('Howdy,', 'mrhaki')
