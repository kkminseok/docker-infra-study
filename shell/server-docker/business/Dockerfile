FROM ubuntu:22.04

RUN apt-get update && apt-get install -y wget gnupg2 software-properties-common

RUN wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | apt-key add - && \
    add-apt-repository --yes https://packages.adoptium.net/artifactory/deb/ && \
    apt-get update && \
    apt-get install -y temurin-17-jdk

RUN java -version

WORKDIR /home/ubuntu

COPY ./business/build/libs/business-0.0.1-SNAPSHOT.jar ./

RUN echo '#!/bin/bash\n\
nohup java -jar /home/ubuntu/business-0.0.1-SNAPSHOT.jar --spring.profiles.active=beta > /home/ubuntu/business.log 2>&1 &\n\
tail -f /dev/null' > /home/ubuntu/start.sh


RUN chmod +x /home/ubuntu/start.sh

CMD ["/home/ubuntu/start.sh"]