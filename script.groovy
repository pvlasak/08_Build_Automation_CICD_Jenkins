def buildJarFile() {
    echo "building the application"
    sh "mvn package"
}

def buildImage() {
    echo ("building the docker image...")
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASSWORD', usernameVariable:'USER')]) {
        sh 'docker build -t petrdeveloper/demo-app:jma-1.2 .'
        sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
        sh 'docker push petrdeveloper/demo-app:jma-1.2'
    }
}

def deployApp() {
    echo("deploying the application....")

}

return this