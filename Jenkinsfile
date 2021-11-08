pipeline{
	agent any
	stages{
		stage('MVN CLEAN'){
			steps{
				echo "MAVEN Clean"
				sh "mvn clean"
			}
		}
		/*stage('MVN TEST'){
			steps{
				echo "MAVEN Test JUnit"
				sh "mvn test"
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
		}*/
		stage('Docker Build'){
			steps{
				dockerImage = docker.build("my-app:latest")
				}
		}
		stage('Docker PUSH'){
			steps{
				docker.withRegistry('', registryCredential){
				 dockerImage.push("my-app:latest")
				}
				}
		}
	}
}
