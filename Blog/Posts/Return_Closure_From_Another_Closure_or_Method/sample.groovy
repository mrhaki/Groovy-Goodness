// Extra transformer argument with default 
// closure implementation.
def repeater = { times, transformer = { it } ->
    { value -> transformer(value) * times }
}

assert repeater(2).call('mrhaki') == 'mrhakimrhaki'
assert repeater(2)('mrhaki') == 'mrhakimrhaki'

assert repeater(2) { it.toUpperCase() } ('mrhaki') == 'MRHAKIMRHAKI'
assert repeater(2, { it.reverse() })('mrhaki') == 'ikahrmikahrm'
