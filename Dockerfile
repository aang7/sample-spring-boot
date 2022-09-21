FROM eclipse-temurin:8-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline # https://tinyurl.com/26hd3ejc
COPY ./src ./src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:8-jdk-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]