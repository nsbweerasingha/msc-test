pipeline {
    agent any

    tools {
        maven 'Maven_3.9'   // Make sure Jenkins has Maven installed with this name
        jdk 'JDK_17'        // Configure JDK 17 in Jenkins
    }

    environment {
        IMAGE_NAME = "springboot-app"
        IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/your-repo/springboot-app.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Run with Docker Compose') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up -d --build'
            }
        }
    }

    post {
        always {
            sh 'docker ps -a'
        }
    }
}
