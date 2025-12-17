## PHASE 1 DOWNLOAD AND INSTALL
#FROM ghcr.io/graalvm/jdk-community:21
#WORKDIR /app
##copy file jar to foler app
#ADD ./build/libs/mobile-banking-api-1.0.jar /app
##COPY build/libs/mobile-banking-api-1.0.jar mobile-banking-api-1.0.jar
## expose pot use on host env
#EXPOSE 8080
##execute file jar
##ENTRYPOINT ["java", "-jar", "mobile-banking-api-1.0.jar"]
#ENTRYPOINT ["java", "-jar", "/app/mobile-banking-api-1.0.jar"]
#
#
#
