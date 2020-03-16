// Let's create a Node hierarchy.
def builder = NodeBuilder.newInstance()
def root = builder.A {
    B {
        D()
        E()
    }
    C {
        F()
    }
}


// Preorder traversal is default, but
// we can also specify it with the boolean
// argument of breadthFirst method.
assert root.breadthFirst(true)
           .collect { node -&gt; node.name() } == ['A', 'B', 'C', 'D', 'E', 'F']
           
// Groovy 2.5.0 adds possibility to
// directly call closure for 
// each node visited with node and level.
def result = []
root.breadthFirst { node, level -&gt; result &lt;&lt; &quot;$level${node.name()}&quot; }

assert result == ['1A', '2B', '2C', '3D', '3E', '3F']

// Postorder traversal is implemented
// as starting at the lowest level and 
// working our way up.
result = []
root.breadthFirst(preorder: false) { node -&gt; result &lt;&lt; node.name() }

assert result == ['D', 'E', 'F', 'B', 'C', 'A']
