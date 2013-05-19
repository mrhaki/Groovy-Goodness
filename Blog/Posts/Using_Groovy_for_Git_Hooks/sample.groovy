#!/usr/bin/env groovy

import static java.lang.System.*

// First argument is the name of the 
// temporary commit message file.
def msgFileName = args[0]

// Get the commit message file.
def msgFile = new File(msgFileName)

// Read commit message from file.
def commitMessage = msgFile.text

if (!commitMessage) {
    err.println 'Commit message is empty'
    exit 1
}

exit 0
