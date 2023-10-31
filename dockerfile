FROM openjdk:8
EXPOSE 8080
ADD target/khaddem.jar Khaddem.jar
ENTRYPOINT ["java","-jar","/Khaddem.jar"]
