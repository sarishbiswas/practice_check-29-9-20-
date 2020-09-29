FROM openjdk:11
LABEL maintainer="nayansengupta99@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/menuitem-service-0.0.1-SNAPSHOT.jar menuitem-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","menuitem-service-0.0.1-SNAPSHOT.jar"]