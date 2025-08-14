# Dependencies Cache and Compilation
FROM maven:3.9.11-eclipse-temurin-21-alpine AS maven-build
WORKDIR /usr/src/to-do-list
COPY ./pom.xml ./ 
COPY ./src ./src
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# Run
FROM eclipse-temurin:21-jre-alpine AS app-runtime
WORKDIR /app
COPY --from=maven-build /usr/src/to-do-list/target/*.jar ./to-do-list.jar
ENTRYPOINT ["java", "-jar", "to-do-list.jar"]
