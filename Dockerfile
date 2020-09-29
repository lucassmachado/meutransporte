FROM openjdk:8-jre
WORKDIR /opt/app
ARG JAR_FILE=target/meutransporte.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080 
ENTRYPOINT java -jar app.jar