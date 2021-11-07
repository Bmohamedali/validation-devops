pipeline{
	agent any
	stages{
		stage('GIT'){
			steps{
				echo "Getting Project from Git"
				git "https://github.com/Bmohamedali/validation-devops.git"
			}
		}
		stage('Test'){
			steps{
				sh "ls"
			}
		}
		/*stage('MVN CLEAN'){
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
		}*/
	}
}
