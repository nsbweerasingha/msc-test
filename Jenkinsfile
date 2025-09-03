pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    environment {
        DOCKER_IMAGE = "gscomp285:latest"
        DOCKER_REGISTRY = "your-dockerhub-username/gscomp285"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-username/gscomp285.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Package Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker tag $DOCKER_IMAGE $DOCKER_REGISTRY'
                    sh 'docker push $DOCKER_REGISTRY'
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up -d --build'
            }
        }
    }

    post {
        success {
            echo "✅ Deployment successful!"
        }
        failure {
            echo "❌ Build/Deploy failed!"
        }
    }
}
