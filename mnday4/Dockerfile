FROM openjdk:14-alpine
COPY build/libs/mnday4-*-all.jar mnday4.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "mnday4.jar"]