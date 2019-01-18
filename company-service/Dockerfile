FROM openjdk:8-jre-alpine
ENV APP_FILE company-service.jar
ENV APP_HOME /usr/apps
EXPOSE 8080

WORKDIR $APP_HOME
COPY target/$APP_FILE $APP_HOME/
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]