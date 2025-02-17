def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', usernameVariable: 'dockerUsername', passwordVariable: '')]) {
    sh "docker build -t ${dockerUsername}/${projectName}:${projectTag} ."
  }
}