def text = 'First line\r\nSecond line\r\n'
def textNormalized = text.normalize()
def platformLineSeparator = System.properties['line.separator']

assert 'First line\nSecond line\n' == textNormalized
assert "First line${platformLineSeparator}Second line${platformLineSeparator}" == textNormalized.denormalize()
