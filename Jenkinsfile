def gv
pipeline {
    agent any
    tools {
        maven 'Maven3.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                gv.buildJarFile()
            }
        }
        stage('build image'){
            steps {
                gv.buildImage()
                }
            }
         stage('deploy app') {
            steps {
                gv.deployApp()
                }
            }
        }
    }


