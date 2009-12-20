// File: run.groovy
import org.mortbay.jetty.*
import org.mortbay.jetty.servlet.*
import groovy.servlet.*

@Grab(group='org.mortbay.jetty', module='jetty-embedded', version='6.1.14')
def startJetty() {
    def jetty = new Server(9090)
    def context = new Context(jetty, '/', Context.SESSIONS)
    context.resourceBase = '.'
    context.addServlet Start, '/start'
    context.addServlet Output, '/output'
    context.setAttribute 'version', '1.0'
    jetty.start()
}

startJetty()
