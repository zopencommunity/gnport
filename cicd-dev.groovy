node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/gnport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/gnport.git'), string(name: 'PORT_DESCRIPTION', value: 'A port of the Google Generate Ninja (gn) meta-build system to z/OS Open Tools project' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
