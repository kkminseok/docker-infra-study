FROM ubuntu:22.04

RUN apt-get update && apt-get install -y wget gnupg2 software-properties-common

RUN wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | apt-key add - && \
    add-apt-repository --yes https://packages.adoptium.net/artifactory/deb/ && \
    apt-get update && \
    apt-get install -y temurin-17-jdk

RUN java -version

WORKDIR /home/ubuntu

COPY ./eurekaServer/build/libs/eurekaServer-0.0.1-SNAPSHOT.jar ./

COPY ./gateway/build/libs/gateway-0.0.1-SNAPSHOT.jar ./

RUN echo '#!/bin/bash\n\
java -jar /home/ubuntu/eurekaServer-0.0.1-SNAPSHOT.jar > /home/ubuntu/eurekaServer.log 2>&1 &\n\
java -jar /home/ubuntu/gateway-0.0.1-SNAPSHOT.jar > /home/ubuntu/gateway.log 2>&1 &\n\
wait' > /home/ubuntu/start.sh

RUN chmod +x /home/ubuntu/start.sh

CMD ["/home/ubuntu/start.sh"]