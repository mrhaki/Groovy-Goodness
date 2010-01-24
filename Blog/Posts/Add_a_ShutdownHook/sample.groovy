addShutdownHook {
    println ''  
    println 'Script is ended.'
}

println 'Script is started.'
println 'Press Ctrl+C to stop this script or wait 10 seconds.'
(1..10).each {
    print "..$it"
    Thread.sleep 1000
}
