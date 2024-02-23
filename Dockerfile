FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTestsx

FROM openjdk:17-jdk-slim AS runtime

WORKDIR /app
VOLUME /tmp
COPY --from=build /app/target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]