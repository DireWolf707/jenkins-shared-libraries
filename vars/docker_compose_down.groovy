def call() {
  sh "[ -f docker-compose.yml ] && docker compose down || echo 'No compose file found, skipping...'"
}