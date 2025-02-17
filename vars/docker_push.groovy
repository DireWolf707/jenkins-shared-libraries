def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', passwordVariable: 'dockerPassword', usernameVariable: 'dockerUsername')]) {
      sh "echo ${dockerPassword} | docker login -u ${dockerUsername} --password-stdin"
      sh "docker image tag ${projectName}:${projectTag} ${dockerUsername}/${projectName}:${projectTag}"
      sh "docker push ${dockerUsername}/${projectName}:${projectTag}"
  }
}