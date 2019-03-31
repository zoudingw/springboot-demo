FROM fabric8/java-jboss-openjdk8-jdk
VOLUME /tmp
ADD spring-boot.jar app.jar
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]