FROM openjdk:11
RUN mkdir -p /app
WORKDIR /app
RUN gradlew clean build
COPY build/libs/*.jar ./app.jar
EXPOSE 5656
CMD [ "java", "-jar", "./app.jar" ]