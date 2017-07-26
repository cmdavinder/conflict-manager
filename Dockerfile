FROM frolvlad/alpine-oraclejdk8:slim
EXPOSE 8080
CMD java -jar /cm-webapp-0.0.1-SNAPSHOT.jar
ADD cm-webapp/target/cm-webapp-0.0.1-SNAPSHOT.jar /cm-webapp-0.0.1-SNAPSHOT.jar
