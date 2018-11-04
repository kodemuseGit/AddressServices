FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 5050
COPY /target/SpringBootHelloWorldWeb-1.0-SNAPSHOT.jar SpringBootHelloWorldWeb-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SpringBootHelloWorldWeb-1.0-SNAPSHOT.jar"]