FROM openjdk:17

WORKDIR /app

COPY ./target/ProductsService-0.0.1-SNAPSHOT.jar /app/ProductsService.jar

CMD ["java", "-jar", "ProductsService.jar"]