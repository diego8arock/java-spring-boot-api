FROM openjdk:11
RUN mkdir -p /app
WORKDIR /app
COPY api/build/libs/*.jar ./app.jar
EXPOSE ${PORT}
CMD [ "java", "-jar", "./app.jar" ]