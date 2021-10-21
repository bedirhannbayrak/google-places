FROM maven:3.8.3-jdk-11-slim AS build
RUN mkdir -p workspace
WORKDIR workspace
COPY pom.xml /workspace
COPY src /workspace/src
COPY frontend /workspace/frontend
RUN mvn -f pom.xml clean install -DskipTests=true


FROM adoptopenjdk
COPY --from=build /workspace/target/*.jar app.jar
ENV PROFILE=docker
ENV apikey=apikey
EXPOSE 8070

ENTRYPOINT [ "sh", "-c", "java  -Dspring.profiles.active=$PROFILE \
-Dapikey=$apikey \
-jar app.jar" ]