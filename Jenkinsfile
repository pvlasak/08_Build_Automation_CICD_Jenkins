def gv
pipeline {
    agent any
    tools {
       maven 'Maven3.9'
    }
    stages {
        stage('increment version') {
            steps {
                script {
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "${version}-${BUILD_NUMBER}"
                }
            }
        }
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
                            sh "docker build -t petrdeveloper/demo-app:${IMAGE_NAME} ."
                            sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
                            sh "docker push petrdeveloper/demo-app:${IMAGE_NAME}"
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

