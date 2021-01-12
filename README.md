# keycloak-sha1
Add SHA1 hashing support to Keycloak.

## Requirements

- Java 11
- Maven 3.6

## Building

- Run `mvn package`
- It should generate a JAR archive under `./target/keycloak-sha1.jar`

## Deploying to Keycloak

1. Move the built JAR file to Keycloak's directory `standalone/deployments/` (on Keycloak under Docker: `/opt/jboss/keycloak/standalone/deployments`)
2. Watch the `standalone/deployments/` for the file `keycloak-sha1.jar.deployed`

:warning: If you find instead the file `keycloak-sha1.jar.failed`, you can run the command `cat keycloak-sha1.jar.failed` to find out what went wrong with your deployment.
