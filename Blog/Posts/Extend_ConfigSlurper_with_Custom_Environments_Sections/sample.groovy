// Configuration script.
def config = '''
// Custom block with setting
// conditional per environment.
servers {
    local {
        mail.host = 'greenmail'
    }

    prod {
        mail.host = 'mail.server'
    }
}

environments {
    local {
        appName = 'local'
    }
    prod {
        appName = 'production'
    }
}
'''

// Helper closure to create a new
// ConfigSlurper for the given environment and
// register servers as section with configuration
// per environment.
def createConfig = { env ->
    def configSlurper = new ConfigSlurper(env)
    configSlurper.registerConditionalBlock('servers', env)
    configSlurper
}

// Create configuration slurper and
// set environment to prod.
def configuration = createConfig('prod').parse(config)

assert configuration.mail.host == 'mail.server'
assert configuration.appName == 'production'


// Create configuration slurper and
// set environment to local.
configuration = createConfig('local').parse(config)

assert configuration.mail.host == 'greenmail'
assert configuration.appName == 'local'
