pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t java-test .'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker run java-test'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
    }
}