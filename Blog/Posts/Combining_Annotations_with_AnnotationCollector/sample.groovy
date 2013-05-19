@EqualsAndHashCode
@ToString
@AnnotationCollector
@interface Simple {}


@Simple
class User {
    String username
}

def user = new User(username: 'mrhaki')
assert user.toString() == 'User(mrhaki)'
