import java.text.*

def showdate(args) {
    def cli = new CliBuilder(usage: 'showdate.groovy -[chflms] [date] [prefix]')
    // Create the list of options.
    cli.with {
        h longOpt: 'help', 'Show usage information'
        c longOpt: 'format-custom', args: 1, argName: 'format', 'Format date with custom format defined by "format"'
        f longOpt: 'format-full',   'Use DateFormat#FULL format'
        l longOpt: 'format-long',   'Use DateFormat#LONG format'
        m longOpt: 'format-medium', 'Use DateFormat#MEDIUM format (default)'
        s longOpt: 'format-short',  'Use DateFormat#SHORT format'
    }

    def options = cli.parse(args)
    if (!options) {
        return
    }
    // Show usage text when -h or --help option is used.
    if (options.h) {
        cli.usage()
        // Will output:
        // usage: showdate.groovy -[chflms] [date] [prefix]
        //  -c,--format-custom <format>   Format date with custom format defined by "format"
        //  -f,--format-full              Use DateFormat#FULL format   
        //  -h,--help                     Show usage information   
        //  -l,--format-long              Use DateFormat#LONG format   
        //  -m,--format-medium            Use DateFormat#MEDIUM format   
        //  -s,--format-short             Use DateFormat#SHORT format   
        return
    }

    // Determine formatter.
    def df = DateFormat.getDateInstance(DateFormat.MEDIUM)  // Defeault.
    if (options.f) {  // Using short option.
        df = DateFormat.getDateInstance(DateFormat.FULL) 
    } else if (options.'format-long') {  // Using long option.
        df = DateFormat.getDateInstance(DateFormat.LONG) 
    } else if (options.'format-medium') {
        df = DateFormat.getDateInstance(DateFormat.MEDIUM) 
    } else if (options.s) {
        df = DateFormat.getDateInstance(DateFormat.SHORT) 
    } else if (options.'format-custom') {
        df = new SimpleDateFormat(options.c)
    }

    // Handle all non-option arguments.
    def prefix = ''  // Default is empty prefix.
    def date = new Date()  // Default is current date.
    def extraArguments = options.arguments()
    if (extraArguments) {
        date = new Date().parse(extraArguments[0])
        // The rest of the arguments belong to the prefix.
        if (extraArguments.size() > 1) {
            prefix = extraArguments[1..-1].join(' ')
        }
    }

    "$prefix${df.format(date)}"
}

// Set locale for assertions.
Locale.setDefault(Locale.US)
assert '12/1/09' == showdate(['--format-short', '2009/12/1'])
assert '12/1/09' == showdate(['-s', '2009/12/1'])
assert 'Dec 1, 2009' == showdate(['2009/12/1'])
assert 'Dec 1, 2009' == showdate(['--format-medium', '2009/12/1'])
assert 'Dec 1, 2009' == showdate(['-m', '2009/12/1'])
assert 'December 1, 2009' == showdate(['--format-long', '2009/12/1'])
assert 'December 1, 2009' == showdate(['-l', '2009/12/1'])
assert 'Tuesday, December 1, 2009' == showdate(['--format-full', '2009/12/1'])
assert 'Tuesday, December 1, 2009' == showdate(['-f', '2009/12/1'])
assert 'Default date format: Dec 1, 2009' == showdate(['2009/12/1', 'Default', 'date', 'format:'])
assert 'Important date: Dec 1, 2009' == showdate(['-m', '2009/12/1', 'Important date:'])
assert 'week 49 of the year 2009 AD' == showdate(['-c', "'week' w 'of the year' yyyy G", '2009/12/1'])
assert '2009/12/01' == showdate(['--format-custom', 'yyyy/MM/dd', '2009/12/01'])
assert '2009' == showdate(['-cyyyy', '2009/12/1'])
assert new Date().format('yyyy/MM/dd') == showdate(['--format-custom', 'yyyy/MM/dd'])

println showdate(args) 
