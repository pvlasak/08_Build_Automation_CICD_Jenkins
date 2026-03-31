def gv 
pipeline {
    agent any

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
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

