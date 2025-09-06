pipeline {
    agent any

    tools {
        maven 'Maven_Home'
    }

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser for testing'
        )
        choice(
            name: 'ENVIRONMENT',
            choices: ['test', 'staging', 'production'],
            description: 'Select environment'
        )
    }

    stages {
        stage('Preparation') {
            steps {
                echo 'Starting Pipeline Execution...'
                echo "Browser: ${params.BROWSER}"
                echo "Environment: ${params.ENVIRONMENT}"

                // Clean workspace
                deleteDir()

                // Checkout code from GitHub
                git branch: 'master',
                    url: 'https://github.com/AhmedAli008/SeleniumFrameWork.git'

                echo 'Code checkout completed successfully'

                // Display project structure
                bat 'dir'
            }
        }

        stage('Build') {
            steps {
                echo 'Starting Maven Build...'

                // Clean and compile the project
                bat 'mvn clean compile'

                echo 'Build completed successfully'
            }
            post {
                success {
                    echo 'Build stage completed successfully'
                }
                failure {
                    echo 'Build stage failed'
                }
            }
        }

        stage('Test') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        echo 'Running Unit Tests...'
                        bat 'mvn test -Dtest=*Test'
                    }
                }
                stage('Integration Tests') {
                    steps {
                        echo 'Running Integration Tests...'
                        bat 'mvn test -Dtest=*IntegrationTest'
                    }
                }
                stage('Selenium Tests') {
                    steps {
                        echo "Running Selenium Tests on ${params.BROWSER} browser..."
                        bat "mvn test -Dbrowser=${params.BROWSER} -Denvironment=${params.ENVIRONMENT}"
                    }
                }
            }
            post {
                always {
                    // Archive test results
                    script {
                        if (fileExists('target/surefire-reports/*.xml')) {
                            junit 'target/surefire-reports/*.xml'
                        }

                        // Archive Allure results if they exist
                        if (fileExists('target/allure-results/')) {
                            allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                            ])
                        }
                    }
                }
                success {
                    echo 'All tests passed successfully'
                }
                failure {
                    echo 'Some tests failed'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Creating JAR package...'

                // Create JAR file
                bat 'mvn package -DskipTests'

                echo 'Package created successfully'
            }
        }

        stage('Results') {
            steps {
                echo 'Collecting and publishing results...'

                // Archive artifacts
                archiveArtifacts artifacts: 'target/*.jar',
                                allowEmptyArchive: true,
                                fingerprint: true

                // Archive test reports
                archiveArtifacts artifacts: 'target/surefire-reports/**',
                                allowEmptyArchive: true

                // Archive screenshots if they exist
                script {
                    if (fileExists('screenshots/')) {
                        archiveArtifacts artifacts: 'screenshots/**',
                                        allowEmptyArchive: true
                    }
                }

                echo 'Results published successfully'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'

            // Clean up workspace if needed
            script {
                if (currentBuild.result == 'SUCCESS') {
                    echo 'Pipeline completed successfully!'
                } else {
                    echo 'Pipeline completed with issues'
                }
            }
        }
        success {
            echo 'Pipeline executed successfully!'
            // You can add email notifications here
        }
        failure {
            echo 'Pipeline failed!'
            // You can add failure notifications here
        }
        unstable {
            echo 'Pipeline is unstable - some tests may have failed'
        }
    }
    post {
        always {
            mail to: 'Ahmed.Ali@originsysglobal.com',
             subject: "Jenkins Build ${env.JOB_NAME} - ${currentBuild.result}",
             body: "Build ${env.BUILD_NUMBER} finished with status: ${currentBuild.result}\n\nCheck: ${env.BUILD_URL}"
    }
}
}