FROM openjdk:latest

ARG JAR_FILE_LOCATION=build/libs/MerchantGuide-1.0-SNAPSHOT.jar

WORKDIR /app/merchantguid

COPY ${JAR_FILE_LOCATION} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]