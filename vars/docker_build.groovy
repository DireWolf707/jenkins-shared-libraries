def call(String projectName, String projectTag) {
  sh "docker build -t ${projectName}:${projectTag} ."
}