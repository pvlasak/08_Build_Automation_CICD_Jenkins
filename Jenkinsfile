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
            input {
                message "Select application version"
                ok "Done"
                parameters {
                    choice(name:'VERSION', choices:['1.1.0', '1.2.1', '1.3.0'], description:'')
                }
            }
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

