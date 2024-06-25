#!/bin/bash
tag=$1
echo $1
docker build -t was-server:$1 -f ../shell/server-docker/business/Dockerfile .
docker build -t business-service:latest -f ../shell/server-docker/business/Dockerfile .


docker run -d --net study-test-net --name wasServer-dockerfile was-server:1.0.9