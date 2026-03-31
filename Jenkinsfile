def gv 
pipeline {
    agent any

    stages {
        stage("init") {
            scripts {
                gv = load "script.groovy"
            }
        }
        stage('build image') {
            steps {
                scripts {
                    gv.BuildApp()
                }
            }
        }
        stage('test') {
            steps {
                scripts {
                    gv.TestApp()
                }
            }
        }
        stage('deploy'){
            steps {
                scripts {
                    gv.DeployApp()
                }
            }
         }
    }
}

