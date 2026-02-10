FROM maven:3.9.12-eclipse-temurin AS build
WORKDIR /usr/src/app
COPY . /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM eclipse-temurin:24.0.2_12-jdk-noble
WORKDIR /usr/src/app

COPY --from=build /usr/src/app/target/probes-0.0.1-SNAPSHOT.jar probes-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/init_container.sh init_container.sh 
COPY --from=build /usr/src/app/certs /usr/src/app/certs

EXPOSE 8080 8443

ENTRYPOINT [ "/usr/src/app/init_container.sh" ]