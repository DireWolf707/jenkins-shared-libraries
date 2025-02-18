def call() {
    nodejs(nodeJSInstallationName: "node-22") {
        sh "cd ~/scripts && npm install"
        sh "node ~/scripts/modifyCompose.js docker-compose.yml"
    }
}
