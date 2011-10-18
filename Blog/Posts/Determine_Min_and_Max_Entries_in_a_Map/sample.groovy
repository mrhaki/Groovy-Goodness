def money = [cents: 5, dime: 2, quarter: 3]

// Determine max entry.
assert money.max { it.value }.value == 5
assert money.max { it.key }.key == 'quarter'  // Use String comparison for key.
assert money.max { a, b ->
    a.key.size() <=> b.key.size() 
}.key == 'quarter'  // Use Comparator and compare key size.

// Determine min entry.
assert money.min { it.value }.value == 2
assert money.min { it.key }.key == 'cents'  // Use String comparison for key.
assert money.min { a, b ->
    a.key.size() <=> b.key.size() 
}.key == 'dime'  // Use Comparator and compare key size.
