pipeline {
    agent any
    tools (
        maven 'Maven3.9'
    )
    stages {
        }
        stage('buildJarFile') {
            steps {
                echo "building the application"
                sh "mvn package"
            }
        }
        stage('buildImage'){
            steps {
                echo ("building the docker image...")
                withCredentials([usernamePassword(credentials: 'dockerhub-credentials', passwordVariable: 'PASSWORD', usernameVariable:'USER')]) {
                    sh 'docker build -t petrdeveloper/demo-app:jma-1.2 .'
                    sh 'echo $PASSWORD | docker login -u $USER --password-stdin'
                    sh 'docker push petrdeveloper/demo-app:jma-1.2'
                }
            }
         }
    }

