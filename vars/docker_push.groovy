def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', passwordVariable: 'dockerPassword', usernameVariable: 'dockerUsername')]) {
      sh "echo ${env.dockerPassword} | docker login -u ${env.dockerUsername} --password-stdin"
      sh "docker image tag ${projectName}:${projectTag} ${env.dockerUsername}/${projectName}:${projectTag}"
      sh "docker push ${dockerUsername}/${projectName}:${projectTag}"
  }
}