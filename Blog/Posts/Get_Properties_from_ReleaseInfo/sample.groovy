// We run this code with Groovy 1.6.7, see assertions.
import org.codehaus.groovy.util.ReleaseInfo

assert '1.6.7' == ReleaseInfo.version
assert '1.6.7' == ReleaseInfo['ImplementationVersion']
assert '12:40 PM' == ReleaseInfo.get('BuildTime')
assert '1.6.7' == ReleaseInfo.get('BundleVersion')
assert '02-Dez-2009' == ReleaseInfo['BuildDate']
