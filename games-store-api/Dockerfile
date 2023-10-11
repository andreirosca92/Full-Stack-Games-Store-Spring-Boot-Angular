FROM openjdk:17
LABEL author="Andrei Rosca"
LABEL description="Postgres Image for demo"
LABEL version="1.0"

COPY *.sql /docker-entrypoint-initdb.d/
ADD target/games-store-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]