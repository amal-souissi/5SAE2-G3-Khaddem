FROM openjdk:11
EXPOSE 8089
ADD /target/khaddem-4.0.jar khaddem.jar
ENTRYPOINT ["java", "-jar","khaddem.jar"]
#  docker build -t gestion-station-ski .
#  docker run -p 8089:8089 --name gestion-station-ski-container -d gestion-station-ski
