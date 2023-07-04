pipeline {
    agent any

    stages {
        stage("Clone repo") {
            steps {
                script {
                    // Let's clone the source
                    git 'https://github.com/fetehzaied/project-devop.git'
                }
            }
        }

        stage("Maven build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }

        stage("Test stage") {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }
    stage("sonar ") {
            steps {
                script {
                    sh "mvn sonar:sonar"
                }
            }
        }
      
   
     
    }
}
