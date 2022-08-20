FROM openjdk:11 as BuildJava
ARG JAR_FILE=build/libs/applications-0.0.1-SNAPSHOT.jar
ARG DATA_FILE=data/data.csv
COPY ${JAR_FILE} app.jar
COPY ${DATA_FILE} ./data.csv
ENTRYPOINT ["java","-jar","/app.jar"]