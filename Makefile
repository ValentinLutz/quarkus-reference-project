help::
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-15s\033[0m %s\n", $$1, $$2}'

clean:: ## clean all project files
	./mvnw clean

compile:: ## compile all classes
	./mvnw compile

dev-migrate:: ## execute flyway locally
	./mvnw flyway:migrate -Pdev -Dflyway.user=dev_user -Dflyway.password=dev_password -f migration-database

dev-docker:: ## start docker containers for local dev
	docker-compose -p quarkus-reference-project -f deployment-local/docker-compose.yaml up -d

dev-docker-down:: ## shutdown docker containers for local dev
	docker-compose -p quarkus-reference-project -f deployment-local/docker-compose.yaml down

dev-java:: ## start the java app locally
	./mvnw compile quarkus:dev -pl app-java

dev-kotlin:: ## start the kotlin app locally
	./mvnw compile quarkus:dev -pl app-kotlin

dev-scala:: ## start the scala app locally
	./mvnw compile quarkus:dev -pl app-scala
