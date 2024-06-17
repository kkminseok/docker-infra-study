FROM ubuntu:22.04

RUN apt-get update && apt-get install -y wget gnupg2 software-properties-common

RUN wget -O- https://packages.adoptium.net/artifactory/api/gpg/key/public | apt-key add - && \
    add-apt-repository --yes https://packages.adoptium.net/artifactory/deb/ && \
    apt-get update && \
    apt-get install -y temurin-17-jdk

RUN java -version

WORKDIR /home/ubuntu

