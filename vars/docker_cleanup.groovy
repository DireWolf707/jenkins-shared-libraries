def call(String projectName, String projectTag) {
  sh "docker image prune -f"
}
