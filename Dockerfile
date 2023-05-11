FROM openjdk:17-jdk
VOLUME /tmp
COPY target/auth.jar auth.jar
ENTRYPOINT ["java", "-jar", "auth.jar"]