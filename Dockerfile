FROM openjdk:11 as BuildJava
ARG JAR_FILE=build/libs/applications-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]