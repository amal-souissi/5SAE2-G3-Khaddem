FROM openjdk:8-jdk-alpine
EXPOSE 8089
ARG JAR_FILE=target/khaddem-4.0.jar
COPY ${JAR_FILE} khaddem.jar
ENTRYPOINT ["java", "-jar", "/khaddem.jar"]
