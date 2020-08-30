FROM openjdk:14-alpine
COPY target/report_service-*.jar report_service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-Dovp.url=${ovp_url}", "-jar", "report_service.jar"]