def call() {
    if (!fileExists('docker-compose.yml')) {
        error("🚨 File 'docker-compose.yml' not found! Failing the build.")
    }
}
