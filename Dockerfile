#
# Build stage
#
FROM maven:3.8.7-amazoncorretto-19 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:19-jdk-slim
COPY --from=build /target/miportfolio-0.0.1-SNAPSHOT.jar demo.jar

# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","miportfolio.jar"]