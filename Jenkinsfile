#!/user/bin/env groovy
library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'https://github.com/pvlasak/jenkins-shared-library.git',
     credentialsId: 'github-credentials'])
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
                    echo "starting build image and pushing to repository"
                    echo "testing automatic multibranch pipepline trigger"
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

