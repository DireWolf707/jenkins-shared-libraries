def call(String url, String branch) {
    git credentialsId: 'github-app', url: "${url}", branch: "${branch}"
}