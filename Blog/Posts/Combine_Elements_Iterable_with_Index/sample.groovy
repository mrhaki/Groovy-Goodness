def list = [3, 20, 10, 2, 1]
assert list.indexed() == [0: 3, 1: 20, 2: 10, 3: 2, 4: 1]


def alphabet = 'a'..'z'

// Combine letters in alphabet
// with position and start at 1.
def alphabetIndices = alphabet.indexed(1)

// alphabetIndices = [1: 'a', 2: 'b', ...]
assert alphabetIndices.findAll { key, value -> key < 4} == [1: 'a', 2: 'b', 3: 'c']

// Find position of each letter
// from 'groovy' in alphabet.
def positionInAlphabet = 'groovy'.inject([]) { result, value ->
    result << alphabetIndices.find { it.value == value }.key
    result
}

assert positionInAlphabet == [7, 18, 15, 15, 22, 25]
