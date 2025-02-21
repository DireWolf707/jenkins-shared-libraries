def call(String url, String branch) {
    withCredentials([usernamePassword(credentialsId: 'github-app',
                                          usernameVariable: 'GITHUB_APP',
                                          passwordVariable: 'GITHUB_ACCESS_TOKEN')]) {
        git credentialsId: "${GITHUB_ACCESS_TOKEN}", url: "${url}", branch: "${branch}"
    }
}