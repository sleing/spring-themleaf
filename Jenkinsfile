pipeline {
  agent any
  triggers {
    GenericTrigger(
        causeString: 'Triggered by develop',
        genericVariables: [[key: 'ref', value: '$.ref']],
        printContributedVariables: true,
        printPostContent: true,
        regexpFilterExpression: 'refs/heads/' + BRANCH_NAME,
        regexpFilterText: 'refs/heads/dev',
        token: 'abc123'
    )
  }
  stages {
    stage('maven build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('master deploy'){
        when{
            branch 'master'
        }
        steps{
            sh 'mv target/*.jar web_test_master.jar'
            script {
                try {
                    sh "kill -9 \$(ps -ef|grep 'java -jar web_test_master.jar'|gawk '\$0 !~/grep/ {print \$2}' |tr -s '\n' ' ')"
                } catch (err) {
                    echo "first run master"
                }
            }
            sh 'nohup java -jar web_test_master.jar >/dev/null 2>&1 &'
        }
    }
    stage('dev deploy'){
        when{
            branch 'dev'
        }
        steps{
            sh 'mv target/*.jar web_test_dev.jar'
            script {
                try {
                    sh "kill -9 \$(ps -ef|grep 'java -jar web_test_dev.jar'|gawk '\$0 !~/grep/ {print \$2}' |tr -s '\n' ' ')"
                } catch (err) {
                    echo "first run dev"
                }
            }
            sh "nohup 'java -jar web_test_dev.jar >/dev/null 2>&1 &'"
        }
    }
  }
}
