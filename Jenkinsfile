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
                script {
                    gv.buildJarFile()
                }
            }
        }
        stage('build image'){
            steps {
                script {
                    gv.buildImage()
                    }
                }
            }
         stage('deploy app') {
            steps {
                script {
                    gv.deployApp()
                    }
                }
            }
        }
    }


