import static java.nio.charset.StandardCharsets.UTF_8 

def message = 'Groovy rocks!'

// Get bytes array for String using UTF8.
def messageBytes = message.getBytes(UTF_8)

// Encode using Base64 URL and Filename encoding.
def messageBase64Url = messageBytes.encodeBase64Url().toString()

// Encode using Base64 URL and Filename encoding with padding.
def messageBase64UrlPad = messageBytes.encodeBase64Url(true).toString()

assert messageBase64Url == 'R3Jvb3Z5IHJvY2tzIQ'
assert messageBase64UrlPad == 'R3Jvb3Z5IHJvY2tzIQ=='

// Decode the String values.
assert new String(messageBase64Url.decodeBase64Url()) == 'Groovy rocks!'
assert new String(messageBase64UrlPad.decodeBase64Url()) == 'Groovy rocks!'
