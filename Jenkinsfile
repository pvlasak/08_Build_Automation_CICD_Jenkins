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
                    BuildJar()
                }
            }
        }
        stage('build image'){
            steps {
                script {
                    BuildImage()
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

