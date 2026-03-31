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
            input {
                message "Select environment where to deploy application to"
                ok "Done"
                parameters {
                    choice(name: "environment-one", choices: ['dev', 'test', 'prod'], description: '')
                    choice(name: "environment-two", choices: ['dev', 'test', 'prod'], description: '')
                }
            }
            steps {
                script {
                    gv.DeployApp()
                }
            }
         }
    }
}

