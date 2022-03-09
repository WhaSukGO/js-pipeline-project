pipeline {
	agent any
    environment {
        CURRENT_VERSION = '1.0.0'
        // ADMIN_CREDENTIALS = credentials('admin_user_credentials')
    }
	parameters {
		string(name: 'VERSION', defaultValue: '', description: 'deployment version')
		choice(name: 'VERSION', choices: ['1.1.0','1.2.0','1.3.0'], description: '')
		booleanParam(name: 'executeTests', defaultValue: true, description: '')
	}    
	stages {
		stage("build") {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/main'
                }
            }
			steps {
				echo 'building the applicaiton...'
                echo "Current version ${CURRENT_VERSION}"
                // echo "Credential used ${ADMIN_CREDENTIALS}"
                withCredentials([[$class: 'UsernamePasswordMultiBinding',
                                    credentialsId: 'admin_user_credentials',
                                    usernameVariable: 'USER',
                                    passwordVariable: 'PWD']])
            {
                echo "Credential used ${USER}"
            }
			}
		}
		stage("test") {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/test' || env.GIT_BRANCH == ''
                }
            }
			steps {
				echo 'testing the applicaiton...'
			}
		}
		stage("deploy") {
			steps {
				echo 'deploying the applicaiton...'
			}
		}
	}
    post {
        always{
            echo "building ..."
        }
        success {
            echo "Success!"
        }
        failure {
            echo "Failed!"
        }
    }
}