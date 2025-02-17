def call(String projectName, String projectTag, String username) {
  sh "docker rmi ${username}/${projectName}:${projectTag}"
}