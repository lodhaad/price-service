# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

EXPOSE 84

# The application's jar file
ARG JAR_FILE=target/price-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} price-service.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/price-service.jar"]