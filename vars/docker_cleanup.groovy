def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', usernameVariable: 'dockerUsername', passwordVariable: '')]) {
    sh "docker rmi ${dockerUsername}/${projectName}:${projectTag}"
  }
}
