def BuildApp() {
    echo('building the docker image...')
    echo("Jenkins is running on the host ${JENKINS_URL}")
    echo("Application files are fetched from ${GIT_URL}")
    echo("Building a docker image version ${VERSION}")
}

def TestApp() {
    echo('testing the app...')
}

def DeployApp() {
    echo('deploying the application...')
}

return this