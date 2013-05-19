// File: ~/.groovy/OutputTransforms.groovy
import javax.swing.JLabel
import javax.swing.ImageIcion

transforms << { result -&gt;
    if (result instanceof String) {
        if (result ==~ /&lt;html&gt;.*&lt;\/html&gt;/) {
            return new JLabel(result)
        } else if (result == 'mrhaki') {
            return new ImageIcon('/Users/mrhaki/Pictures/blog/haki-logo-black-64.png')
        } else {
            return "Groovy Console says: $result"
        }
    }
}
