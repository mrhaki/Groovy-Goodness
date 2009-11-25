new File('.').eachFileMatch(~/.*.jpg$/) {
    // Use ImageMagick convert command to create a thumbnail for a JPEG image.
    def converter = "convert ${it.name} -thumbnail 100x100 thumb-${it.name - '.jpg'}.gif".execute()
    converter.waitFor()

    if (converter.exitValue()) {
        println "Error creating thumbnail for ${it.name}:"
        println converter.text
    } else {
        println "Created a thumbnail for ${it.name}."
    }
}

// We can also use a List. Useful if arguments have spaces or 
// for shell wildcards like *.
def thumbnail = ["convert", "file.jpg", "-thumbnail", "100x100", "thumb-file.gif"].execute()
thumbnail.waitFor()

println "Exit value: ${thumbnail.exitValue()}"
println "Output: ${thumbnail.text}"
