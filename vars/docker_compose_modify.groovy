def call() {
    sh 'cd ~/scripts && npm install'
    sh "node ~/scripts/modifyCompose.js docker-compose.yml"
}
