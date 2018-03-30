node {

   stage('Clone Repository') {
        git 'https://github.com/surenraju/course-api.git'
   }
   
   stage('Build Docker image') {
   		sh "docker rm -f springio/course-api-database"
   		sh "mvn package docker:build"
   }
   
   stage('Deploy Spring Boot Application') {
        sh "docker run -p 8080:8080 -t springio/course-api-database"
   }

}