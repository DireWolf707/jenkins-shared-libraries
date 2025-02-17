def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', usernameVariable: 'dockerUsername')]) {
    sh "docker rmi ${env.dockerUsername}/${projectName}:${projectTag}"
  }
}