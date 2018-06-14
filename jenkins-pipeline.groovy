node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'node-1', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'node-1')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}
