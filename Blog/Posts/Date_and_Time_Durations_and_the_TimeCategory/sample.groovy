import groovy.time.*
import org.codehaus.groovy.runtime.TimeCategory

// Define period of 2 years, 3 months, 15 days, 0 hours, 23 minutes, 2 seconds and 0 milliseconds.
def period = new DatumDependentDuration(2, 3, 15, 0, 23, 2, 0)
assert '2 years, 3 months, 15 days, 23 minutes, 2.000 seconds' == period.toString()
def year2000 = new Date(100, 0, 0)  // Jan 1, 2000
assert 'Mon Apr 15 00:23:02 UTC 2002' == (period + year2000).toString()

// Define time period of 5 hours, 54 minutes and 30 milliseconds.
def time = new TimeDuration(5, 54, 0, 30)
assert '5 hours, 54 minutes, 0.030 seconds' == time.toString()

use (TimeCategory) {
    assert period.toString() == (2.years + 3.months + 15.days + 0.hour + 23.minutes + 2.seconds).toString()
    assert time.toString() == (5.hours + 54.minutes + 30.milliseconds).toString()

    // We can use period.from.now syntax.    
    def d1 = 1.week - 1.day
    def d2 = new Date() + 6.days
    assert d2.format('yyyy-MM-dd') == d1.from.now.toString()

    // We can use period.ago syntax.
    def d3 = 3.days.ago
    def d4 = new Date() - 3
    assert d4.format('yyyy-MM-dd') == d3.toString()
}
