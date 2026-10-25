pipeline {
    agent any

    tools {
        maven 'Maven3'          // name configured in Manage Jenkins > Tools
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
                sh 'mvn clean package'
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success { echo 'Build succeeded' }
        failure { echo 'Build failed' }
    }
}
