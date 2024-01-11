FROM openjdk:17-oracle
EXPOSE 8080
COPY ./build/libs/*.jar ROOT.jar
CMD ["java","-jar","-Duser.timezone=Asia/Seoul","-Dspring.profiles.active=${PROFILE}" ,"ROOT.war"]