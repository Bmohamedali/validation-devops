FROM openjdk:11 as builder
RUN apt-get update -y && apt-get install maven -y
COPY . .
RUN mvn clean package


FROM openjdk:11
COPY --from=builder /target /app
WORKDIR /app
EXPOSE 8081
CMD ["java", "-jar", "Nhl-0.0.1-SNAPSHOT.jar"]