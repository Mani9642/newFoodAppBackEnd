FROM openjdk:11
RUN mkdir /foodapp
WORKDIR /home/ubuntu/foodAppBackEndDevops
EXPOSE 8095
COPY target/foodApp-0.0.1-SNAPSHOT.jar /foodapp/
ENTRYPOINT ["java","-jar","/foodapp/foodApp-0.0.1-SNAPSHOT.jar"]
