def s = 'Argh, Groovy you say, mate?'

String encoded = s.bytes.encodeBase64().toString()
assert 'QXJnaCwgR3Jvb3Z5IHlvdSBzYXksIG1hdGU/' == encoded

byte[] decoded = encoded.decodeBase64()
assert s == new String(decoded)
