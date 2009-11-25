package com.mrhaki.blog

// Old style singleton class.
public class StringUtil {
    private static final StringUtil instance = new StringUtil();

    private StringUtil() {
    }

    public static StringUtil getInstance() { 
        return instance;
    }

    int count(text) { 
        text.size() 
    }
}

assert 6 == StringUtil.instance.count('mrhaki')

// Use @Singleton to create a valid singleton class.
// We can also use @Singleton(lazy=true) for a lazy loading
// singleton class.
@Singleton 
class Util {
    int count(text) {
        text.size()
    }
}

assert 6 == Util.instance.count("mrhaki")

try {
    new Util()
} catch (e) {
    assert e instanceof RuntimeException
    assert "Can't instantiate singleton com.mrhaki.blog.Util. Use com.mrhaki.blog.Util.instance" == e.message
}
