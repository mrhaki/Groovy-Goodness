def s = "Groovy rocks!"

// Drop first 7 characters.
assert s.drop(7) == "rocks!"

// Drop last 7 characters.
assert s.dropRight(7) == "Groovy"


// Take first 6 characters.
assert s.take(6) == "Groovy"

// Take last 6 characters.
assert s.takeRight(6) == "rocks!"
