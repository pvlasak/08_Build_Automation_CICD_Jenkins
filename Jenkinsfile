#!/user/bin/env groovy
library identifier: 'jenkins-shared-library@main', retriever: moderSCM(
    [$class: 'GitSCMSource',
     remote: 'https://github.com/pvlasak/08_Build_Automation_CICD_Jenkins.git',
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

