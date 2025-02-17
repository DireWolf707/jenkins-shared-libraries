def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', usernameVariable: 'dockerUsername', passwordVariable: 'dockerPassword')]) {
      sh "echo ${dockerPassword} | docker login -u ${dockerUsername} --password-stdin"
      sh "docker push ${dockerUsername}/${projectName}:${projectTag}"
  }
}