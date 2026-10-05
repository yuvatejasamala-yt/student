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
}