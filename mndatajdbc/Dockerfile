FROM openjdk:14-alpine
COPY build/libs/mndatajdbc-*-all.jar mndatajdbc.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mndatajdbc.jar"]