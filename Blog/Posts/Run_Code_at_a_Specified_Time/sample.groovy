// File: timer.groovy
def timer = new Timer()
def task = timer.runAfter(10000) {
    println "Actually executed at ${new Date()}."
}
println "Current date is ${new Date()}. Task is executed at ${new Date(task.scheduledExecutionTime())}."

// File: newtimer.groovy
class GroovyTimerTask extends TimerTask {
    Closure closure
    void run() {
        closure()
    }
}

class TimerMethods {
    static TimerTask runEvery(Timer timer, long delay, long period, Closure codeToRun) {
        TimerTask task = new GroovyTimerTask(closure: codeToRun)
        timer.schedule task, delay, period
        task
    }
}

use (TimerMethods) {
    def timer = new Timer()
    def task = timer.runEvery(1000, 5000) {
        println "Task executed at ${new Date()}."
    }
    println "Current date is ${new Date()}."
}
