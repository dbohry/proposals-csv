FROM openjdk:11 as BuildJava
ARG JAR_FILE=build/libs/proposals-csv-0.0.1-SNAPSHOT.jar
ARG DATA_FILE=data.csv
COPY ${JAR_FILE} app.jar
COPY ${DATA_FILE} data.csv
ENTRYPOINT ["java","-jar","/app.jar"]