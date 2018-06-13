node('maven') {
    stage('build') {
        echo 'building app :)'
        openshiftBuild(buildConfig: 'grell-node', showBuildLogs: 'true')
    }
    stage('verify') {
        echo 'dummy verification....'
    }
    stage('deploy') {
        input 'Manual Approval'
        openshiftDeploy(deploymentConfig: 'grell-node')
    }
    stage('promoting to QA') {
       echo 'fake stage...'
       sleep 5 
    }
}
