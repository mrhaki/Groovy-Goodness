@Grab('commons-lang:commons-lang:2.5')
import org.apache.commons.lang.RandomStringUtils as RSU

def randomClosure = { size, letters, numbers ->
    // Invoke RandomStringUtils.random() method 
    RSU.random size, letters, numbers
}

def randomNumbers = randomClosure.rcurry(false, true)  // letters = false, numbers = true
def randomLetters = randomClosure.ncurry(1, true, false) // letters = true, numbers = false

println randomClosure(10, true, true)  // Sample output: VG7mffNAdA
println randomNumbers(10)              // Sample output: 8099670444
println randomLetters(10)              // Sample output: ZOHlHewEPU
