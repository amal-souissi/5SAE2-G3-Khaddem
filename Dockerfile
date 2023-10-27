FROM openjdk:8
EXPOSE 8089
ADD /target/khaddem-4.0.jar khaddem.jar
ENTRYPOINT ["java", "-jar","khaddem.jar"]