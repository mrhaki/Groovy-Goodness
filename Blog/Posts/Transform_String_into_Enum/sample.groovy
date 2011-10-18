enum Compass {
    NORTH, EAST, SOUTH, WEST
}

// Coersion with as keyword.
def north = 'NORTH' as Compass
assert north == Compass.NORTH

// Coersion by type.
Compass south = 'south'.toUpperCase()
assert south == Compass.SOUTH

def result = ['EA', 'WE'].collect {
    // Coersion of GString to Enum.
    "${it}ST" as Compass
}
assert result[0] == Compass.EAST
assert result[1] == Compass.WEST
