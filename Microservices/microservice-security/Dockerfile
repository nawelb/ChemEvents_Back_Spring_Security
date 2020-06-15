FROM openjdk:8
WORKDIR /usr/app
COPY target/microservice-user.war ./
EXPOSE 8888
CMD ["java","-jar","microservice-user.war"]