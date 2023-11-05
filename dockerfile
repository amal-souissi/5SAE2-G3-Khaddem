FROM openjdk:8
EXPOSE 8080
RUN apk --no-cache add curl
ADD target/khaddem.jar Khaddem.jar
ENTRYPOINT ["java","-jar","/Khaddem.jar"]
