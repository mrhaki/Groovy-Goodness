import java.nio.charset.Charset

def signs = (2..10) + ['J', 'Q', 'K', 'A']
def symbols = ['♣', '♦', '♥', '♠']

// Create list as [♣2, ♦2, ♥2, ♠2, ..., ♣A, ♦A, ♥A, ♠A] 
def cards = [symbols, signs].combinations().collect { it.join() }

// Store original cards list.
def deck = cards.asImmutable()

// We should have 52 cards.
assert cards.size() == 52

// Let's shuffle the cards.
// Notice this will change the cards list.
cards.shuffle()
 
assert cards.every { card -> deck.contains(card) }

println cards.take(5) // Possible output: [♣6, ♠A,  ♥Q, ♦Q, ♠5]

// We can use our own Random object for shuffling.
cards.shuffle(new Random(42))

assert cards.every { card -> deck.contains(card) }

println cards.take(5)  // Possible output: [♦5, ♦2, ♦3, ♣7, ♦J]


// Store first 5 cards.
def hand = cards.take(5)

// Using shuffled we get a new list 
// with items in random order. 
// The original list is not changed.
def shuffledCards = cards.shuffled()

assert shuffledCards.size() == cards.size()
assert shuffledCards.every { card -> cards.contains(card) }

// Original list has not changed.
assert hand == cards.take(5)

println shuffledCards.take(5) // Possible output: [♣4, ♠2, ♠6, ♥Q, ♦4]

// We can pass our own Random object.
def randomizer = new Random(42)
def randomCards = cards.shuffled(randomizer)

assert randomCards.size() == cards.size()
assert randomCards.every { card -> cards.contains(card) }

println randomCards.take(5) // Possible output: [♥5, ♠6, ♠8, ♣3, ♠4]
