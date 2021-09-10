FROM openjdk:11
RUN mkdir -p /app
WORKDIR /app
COPY api/build/libs/*.jar ./app.jar
EXPOSE 8080
CMD [ "java", "-jar", "./app.jar" ]