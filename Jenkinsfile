def gv 
pipeline {
    agent any

    stage("init") {
        scripts {
                gv = load "script.groovy"
        }
    }

    stages {
        stage('build image') {
            steps {
                script {
                    gv.BuildApp()
                }
            }
        }
        stage('test') {
            steps {
                script {
                    gv.TestApp()
                }
            }
        }
        stage('deploy'){
            steps {
                script {
                    gv.DeployApp()
                }
            }
         }
    }
}

