FROM ubuntu:18.04
RUN apt update
RUN apt install -y openjdk-8-jre
RUN mkdir app
COPY build/libs/wonka-hr-0.0.1-SNAPSHOT.jar /opt/wonka-hr/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/wonka-hr/wonka-hr-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
