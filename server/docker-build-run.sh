#!/bin/bash
tag=$1
echo $1
docker build -t was-server:$1 -f ../shell/server-docker/Dockerfile .


docker run -d --name wasServer-dockerfile -p 18081:18081 was-server:1.0.3 