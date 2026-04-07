def gv
pipeline {
    agent any
    tools {
        maven 'Maven3.9'
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    sh "mvn package"
                }
            }
        }
        stage('build image'){
            steps {
                script {
                        echo ("building the docker image...")
                        withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASSWORD', usernameVariable:'USER')]) {
                            sh 'docker build -t petrdeveloper/demo-app:jma-1.2 .'
                            sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
                            sh 'docker push petrdeveloper/demo-app:jma-1.2'
                        }
                    }
                }
            }
         stage('deploy app') {
            steps {
                script {
                    echo("deploying the application....")
                    }
                }
            }
        }
    }

