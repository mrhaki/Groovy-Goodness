// Create AntBuilder.
def ant = new AntBuilder()

// Simple echo task.
def world = 'Groovy'
ant.echo("Hello $world")  // Output: [echo] Hello Groovy

// Ant task properties are defined as a map.
def options = [src: 'http://mrhaki.blogspot.com', dest: 'blog.html']
ant.get(options)
// is the same as
ant.get(src: 'http://mrhaki.blogspot.com', dest: 'blog.html']

// Nice builder syntax for tasks with for example filesets.
def zipfile = 'test.zip'
def current = '.'
ant.zip(destfile: zipfile) {
    fileset(dir: current) {
        include(name: '**/*.txt')
    }
}
