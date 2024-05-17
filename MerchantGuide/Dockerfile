FROM gradle:7.5-jdk-alpine AS builder

WORKDIR /app

COPY . .

RUN ./gradlew build

FROM openjdk:17

WORKDIR /app

COPY --from=builder /app/gradlew ./gradlew

CMD ["/app/gradlew", "run"]