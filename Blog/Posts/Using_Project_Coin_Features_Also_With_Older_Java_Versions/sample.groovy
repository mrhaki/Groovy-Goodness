import java.lang.reflect.*

// Multicatch.
@groovy.transform.ToString
class Person {
    String name
}

try {
    final Person p = new Person(name: 'mrhaki')
    final Method toString = p.class.getMethod("toString1", null)
    final Object result = toString.invoke(p, null)
} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
    assert e
}
