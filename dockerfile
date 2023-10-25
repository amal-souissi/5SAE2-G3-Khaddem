

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","/Khaddem.jar"]
EXPOSE 8089