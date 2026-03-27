pipeline {
    agent any

    stages {
        stage('build image') {
            steps {
                echo "building the docker image..."
            }
        }
        stage('test') {
            steps {
                echo 'testing the application...'
            }
        }
        stage('deploy'){
            steps {
                echo 'deploying the application....'
            }
         }
    }
}

