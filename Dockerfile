FROM openjdk:11-jre-slim
EXPOSE 8080
ENV TZ=Asia/Seoul
COPY ./build/libs/football-0.0.1.jar ./app.jar
ENTRYPOINT ["java","-jar","/app.jar"]