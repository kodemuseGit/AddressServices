FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 6161
COPY /target/AddressServices-1.0-SNAPSHOT.jar AddressServices-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/AddressServices-1.0-SNAPSHOT.jar"]