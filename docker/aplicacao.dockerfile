FROM maven:3.6.0-jdk-8
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app/
RUN mvn -f pom.xml clean package

FROM openjdk:8-jre
ARG JAR_FILE=target/meutransporte.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Ddb.url=${DB_URL}","-Ddb.username=${DB_USERNAME}","-Ddb.password=${DB_PASSWORD}","app.jar"]