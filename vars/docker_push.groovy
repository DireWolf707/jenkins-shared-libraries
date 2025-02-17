def call(String projectName, String projectTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-login', passwordVariable: 'dockerPassword', usernameVariable: 'dockerUsername')]) {
      sh "docker login -u ${dockerUsername} -p ${dockerPassword}"
      sh "docker image tag ${projectName}:${projectTag} ${env.dockerUsername}/${projectName}:${projectTag}"
      sh "docker push ${username}/${projectName}:${projectTag}"
  }
}