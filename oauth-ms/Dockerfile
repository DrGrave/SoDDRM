FROM java:8-jre
ADD ./build/libs/oauth-ms*.jar app.jar
ADD ./build/keystore.p12 keystore.p12
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]