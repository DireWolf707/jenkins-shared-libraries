def call() {
  if (fileExists('docker-compose.yml')) {
    sh "docker compose down"
  }
}