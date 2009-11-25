// Configuration script as String, but can also be URL, file.
def mail = '''

// Dot notation.
mail.hostname = 'localhost'  

// Scoped closure notation.
mail {  
    // Using Groovy constructs.
    ['user', 'password'].each { 
        this."${it}" = 'secret' 
    }
}

// Environments section.
environments {
    dev {
        mail.hostname = 'local'
    }
    test {
        mail.hostname = 'test'
    }
    prod {
        mail.hostname = 'prod'
    }
}
'''

// Another configuration script.
def app = '''
app {
    version = version()  // Use method in script.
}

// Define method to build version info.
def version() {
    "1.0-${releasedate.format('yyyy_MM_dd')}"
}
'''

// Read mail configuration script for the prod environment.
def mailConfig = new ConfigSlurper('prod').parse(mail)

// We can pass information to the configuration with
// the setBinding method.
def appSlurper = new ConfigSlurper()
appSlurper.setBinding([releasedate: new Date(109, 9, 10)])
def appConfig = appSlurper.parse(app)

// Both configurations are merged into one.
def config = mailConfig.merge(appConfig)

assert 'prod' == config.mail.hostname
assert 'secret' == config.mail.user
assert 'secret' == config.mail.password
assert '1.0-2009_10_10' == config.app.version
