#!/user/bin/env groovy
@Library('jenkins-shared-library')
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
                    buildJar()
                }
            }
        }
        stage('build and push image'){
            steps {
                script {
                    buildImage('petrdeveloper/demo-app:jma-2.0')
                    dockerLogin()
                    dockerPush('petrdeveloper/demo-app:jma-2.0')
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

