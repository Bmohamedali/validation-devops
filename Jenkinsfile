pipeline{
	agent any
	stages{
		stage('MVN CLEAN'){
			steps{
				echo "MAVEN Clean"
				sh "mvn clean"
			}
		}
		stage('MVN TEST'){
			steps{
				echo "MAVEN Test JUnit"
				sh "mvn test"
			}
		}
		stage('SONARQUBE'){
			steps{
				echo "SONARQUBE Analysis"
				sh "mvn clean verify sonar:sonar \
  					-Dsonar.projectKey=projet-devops \
  					-Dsonar.host.url=http://localhost:9000 \
  					-Dsonar.login=eb1bf5133193488f0420893864ba45a4c994220a"
			}
		}
		stage('Package'){
			steps{
				echo "MAVEN Package"
				sh "mvn clean package -Dmaven.test.skip=true deploy:deploy-file \
									  -DgroupId=tn.esprit \
									  -DartifactId=timesheet-devops \
									  -Dversion=1.0 \
									  -DgeneratePom=true \
									  -Dpackaging=jar \
									  -DrepositoryId=deploymentRepo \
									  -Durl=http://localhost:1235/repository/maven-releases/ \
									  -Dfile=Nhl-0.0.1-SNAPSHOT.jar"
				}
		}
		stage('Docker Build'){
			steps{
				script{
					echo "Build docker image"
					dockerImage = docker.build("my-app:latest")
					}
				}
		}
		stage('Docker PUSH'){
			steps{
				script{
					echo "Push docker image"
					docker.withRegistry('', registryCredential){
				 		dockerImage.push("my-app:latest")
						}
					}
				}
		}
	}
}
