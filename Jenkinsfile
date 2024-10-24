pipeline
{
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the Application'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing the Application'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying the Application'
            }
        }
    }

    post {
        always
        {
            echo 'This will always execute'
        }
    }
}