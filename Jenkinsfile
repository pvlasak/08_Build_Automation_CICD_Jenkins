def gv 
pipeline {
    agent any
    parameters {
        booleanParam(name:'executeTest', defaultValue: true, description:'') 
    }
    environment {
        DEVELOPER_NAME: 'Peter'
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
            when {
                expression {params.executeTest}
            }
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
                    choice(name: "ONEENV", choices: ['dev', 'test', 'prod'], description: '')
                    choice(name: "TWOENV", choices: ['dev', 'test', 'prod'], description: '')
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

