def s = 'Gr00vy is gr8'

def replacement = {
    // Change 8 to eat
    if (it == '8') {
        'eat'
    // Change 0 to o
    } else if (it == '0') {
        'o'
    // Do not transform
    } else {
        null
    }
}

assert s.collectReplacements(replacement) == 'Groovy is great'
