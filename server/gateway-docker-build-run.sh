#!/bin/bash
tag=$1
docker build -t gateway-server:latest -f ../shell/server-docker/gateway/Dockerfile .

docker run -d --net study-test-net --name gwServer-dockerfile -p 18081:18081 -p 8761:8761 gateway-server:1.0.1