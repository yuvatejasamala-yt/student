pipeline {
    agent any

    tools {
        maven 'MAVEN-HOME'
    }

    stages {
        stage('Git Clone & Clean') {
            steps {
                bat 'mvn clean -f student/pom.xml'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn package -f student/pom.xml -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test -f student/pom.xml'
            }
        }
    }

    post {
        success {
            emailext(
                subject: "Jenkins SUCCESS - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    <h2>Jenkins Build Successful</h2>
                    <p><b>Job:</b> ${env.JOB_NAME}</p>
                    <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                    <p><b>Status:</b> SUCCESS</p>
                    <p>The Maven build and tests completed successfully.</p>
                """,
                to: "yuvatejasamala@gmail.com"
            )
        }

        failure {
            emailext(
                subject: "Jenkins FAILED - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    <h2>Jenkins Build Failed</h2>
                    <p><b>Job:</b> ${env.JOB_NAME}</p>
                    <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                    <p><b>Status:</b> FAILURE</p>
                    <p>Please check the Jenkins console output.</p>
                """,
                to: "yuvatejasamala@gmail.com"
            )
        }
    }
}