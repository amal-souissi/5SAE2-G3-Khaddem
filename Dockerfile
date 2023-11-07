FROM openjdk:11
EXPOSE 8080
ADD target/5SE2-G3-Khaddem.jar 5SE2-G3-Khaddem.jar
ENTRYPOINT ["java" ,"-jar" , "5SE2-G3-Khaddem.jar"]
#dockerfile