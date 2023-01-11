FROM amazoncorretto:19-alpine-jdk
MAINTAINER yaninahaspert

COPY out/artifacts/miportfolio_jar/miportfolio.jar miportfolio.jar

ENTRYPOINT ["java","-jar","/miportfolio.jar"]