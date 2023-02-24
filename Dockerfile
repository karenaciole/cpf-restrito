FROM openjdk:17-jdk-alpine
LABEL maintainer="karen.alves@ccc.ufcg.edu.br"

WORKDIR /app

COPY target/cpf-restrito-0.0.1-SNAPSHOT.jar /app/cpf-restrito.jar

RUN apk update && apk add postgresql-client

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cpf-restrito.jar"]
