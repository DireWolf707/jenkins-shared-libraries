def call(String envsJson) {
    // Ensure the parameter is provided
    if (!envsJson) {
        error "The containersJson parameter is required but not provided."
    }

    // Parse the JSON string into an object
    def containerData = readJSON text: envsJson

    // Ensure the parsed JSON contains a 'containers' array
    if (!envsData?.containers) {
        error "Invalid JSON format: Expected 'containers' array."
    }

    // Define the target directory
    def envDir = "tempEnvs"

    // Create the directory if it does not exist
    script {
        sh "mkdir -p ${envDir}"
    }

    // Loop over containers and generate .env files inside tempEnvs
    envsData.containers.each { container ->
        if (!container.name || !container.env) {
            error "Each container must have 'name' and 'env' properties. Issue with: ${container}"
        }
        
        def filePath = "${envDir}/${container.name}.env"
        echo "Creating env file for ${container.name} -> ${filePath}"
        writeFile file: filePath, text: container.env
    }
}
