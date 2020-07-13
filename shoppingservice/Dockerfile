FROM openjdk:14-alpine
COPY build/libs/shoppingservice-*-all.jar shoppingservice.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "shoppingservice.jar"]