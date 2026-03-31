def gv 
pipeline {
    agent any
    parameters {
        choice(name:'VERSION', choices:['1.1.0', '1.2.1', '1.3.0'], description:'')
    }
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

