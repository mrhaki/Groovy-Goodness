import javax.management.remote.*
import javax.management.*
import groovy.jmx.builder.*

// Setup JMX connection.
def connection = new JmxBuilder().client(port: 8090, host: 'localhost')
connection.connect()

// Get the MBeanServer.
def mbeans = connection.MBeanServerConnection

println "Total MBeans: ${mbeans.MBeanCount}\n"

// Create GroovyMBean.
def mbean = new GroovyMBean(mbeans, 'org.mortbay.jetty.webapp:type=webappcontext,name=test,id=0')
println mbean  // Outputs all attributes and operations.

assert mbean.running  // Get attribute value.
assert '/test' == mbean.contextPath
mbean.contextPath = '/changed'  // Set attribute value.
assert '/changed' == mbean.contextPath
mbean.stop()  // Invoke stop() method.
assert !mbean.running
mbean.setContextAttribute 'groovy', true  // Invoke setContextAttribute(String, Object) method.
assert mbean.contextAttributes.groovy

// Find MBeans with Groovy collection methods.
def webBean = mbeans.queryNames(new ObjectName('org.mortbay.jetty.webapp:*'), null).find {
    it.getKeyProperty('name') == 'test-jndi' &&
    it.getKeyProperty('type') == 'webappcontext'
}
mbean = new GroovyMBean(mbeans, webBean)
assert mbean

// Classical way to invoke operations and access attributes,
// which is less readable than the GroovyMBean version.
assert mbeans.getAttribute(webBean, "running")
mbeans.invoke(webBean, "setContextAttribute", ['groovy', Boolean.TRUE] as Object[], ['java.lang.String', 'java.lang.Object'] as String[])
assert (mbeans.getAttribute(webBean, "contextAttributes").get("groovy"))
mbeans.setAttribute(webBean, new Attribute("distributable", Boolean.TRUE))
assert (mbeans.getAttribute(webBean, "distributable"))

def gmbeans = mbeans.queryNames(new ObjectName('org.mortbay.jetty.webapp:*'), null).inject([]) { result, name ->
    result << new GroovyMBean(mbeans, name)
}
println ''
gmbeans.each { 
    println "${it.displayName} is ${it.running ? 'running' : 'stopped'}" 
}
