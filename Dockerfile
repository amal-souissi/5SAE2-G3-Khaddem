FROM openjdk:11
EXPOSE 8080
ADD target/5sae2-g3-khaddem.jar 5sae2-g3-khaddem.jar
ENTRYPOINT ["java" ,"-jar" , "5sae2-g3-khaddem.jar"]
#dockerfile