def list = [3, 20, 10, 2, 1]
assert list.indices == 0..4


// Combine letters in alphabet
// with position (zero-based).
def alphabet = 'a'..'z'
def alphabetIndices = [alphabet, alphabet.indices].transpose()
// alphabetIndices = [['a', 0], ['b', 1], ...]

// Find position of each letter
// from 'groovy' in alphabet.
def positionInAlphabet = 'groovy'.inject([]) { result, value ->
    result << alphabetIndices.find { it[0] == value }[1] + 1
    result
}

assert positionInAlphabet == [7, 18, 15, 15, 22, 25]
