@GrabResolver(name='custom', root='http://customserver/repo', m2Compatible='true')
@Grab('com.mrhaki:groovy-samples:1.0')
import com.mrhaki.groovy.Sample

def s = new Sample()
s.justToShowGrabResolver()  // Just a sample
