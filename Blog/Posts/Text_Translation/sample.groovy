// Source set and replacement set are equal size.
assert 'I 10v3 9r00vy' == 'I love Groovy'.tr('loeG', '1039')

// Regular expression style range
assert 'mrHAKI' == 'mrhaki'.tr('a-k', 'A-K')

// Replacement set is smaller than source set.
assert 'Gr8888' == 'Groovy'.tr('ovy', '8')
