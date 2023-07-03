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

        stage("Sonar metrics") {
            steps {
                script {
                    sh "mvn sonar:sonar"
                }
            }
        }

        stage("Deployment stage") {
            steps {
                script {
                    sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit -DartifactId=ExamThourayaS2 -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.244:8081/repository/maven-releases/ -Dfile=target/ExamThourayaS2-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}
