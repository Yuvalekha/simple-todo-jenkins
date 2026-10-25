pipeline {
    agent any

    tools {
        maven 'Maven3'        
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
            environment {
                MAVEN_OPTS = '-Xmx256m'
            }    
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
    success {
        slackSend(
            channel: '#jenkins-builds',
            color: 'good',
            message: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        )
    }
    failure {
        slackSend(
            channel: '#jenkins-builds',
            color: 'danger',
            message: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}console|Console>)"
        )
    }
}
}
