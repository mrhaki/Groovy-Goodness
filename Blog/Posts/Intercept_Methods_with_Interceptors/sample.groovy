class HelloInterceptor implements Interceptor {
    boolean invokeMethod = true

    boolean doInvoke() {
        invokeMethod
    }
    
    Object beforeInvoke(Object obj, String name, Object[] args) {
        // We don't want the shout() method to be executed.
        if (name == 'shout') {
            invokeMethod = false
        }
    }
    
    Object afterInvoke(Object obj, String name, Object[] args, Object result) {
        if (name == 'shout') {
            invokeMethod = true
            // Set an alternate result for the shout() method.
            result = "sssshhh... You don't have to shout."
        }
        result
    }
}

class Hello {
    String say() { "Hello Groovy" }
    String shout() { "HELLO GROOVY" }
}

// Create ProxyMetaClass and assign interceptor.
def proxy = ProxyMetaClass.getInstance(Hello)
def interceptor = new HelloInterceptor()
proxy.interceptor = interceptor

// Invoke Hello methods in use block so methods are intercepted.
proxy.use {
    def h = new Hello()
    assert 'Hello Groovy' == h.say()
    assert "sssshhh... You don't have to shout." == h.shout()
}
