FROM amazoncorretto:8-alpine-jdk
MAINTAINER martinetorre
COPY met/target/met-0.0.1-SNAPSHOT.jar met-app.jar  
ENTRYPOINT ["java","-jar","/met-app.jar"]
EXPOSE 8080
