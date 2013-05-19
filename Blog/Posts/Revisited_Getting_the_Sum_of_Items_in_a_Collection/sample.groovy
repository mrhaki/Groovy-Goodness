assert products.sum { it.price } == 1594
assert products.price.sum() == 1594
assert products*.price.sum() == 1594
