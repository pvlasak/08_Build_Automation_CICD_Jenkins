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
        stage('test application') {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('build image'){
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildImage()
                    }
                }
            }
         stage('deploy app') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.deployApp()
                    }
                }
            }
        }
    }


