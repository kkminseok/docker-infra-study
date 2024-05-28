#!/bin/bash

echo "Starting entrypoint script"

# 업데이트 및 패키지 설치
apt-get update
apt-get install -y build-essential libpcre3 libpcre3-dev
apt-get install -y curl


# 디렉터리 생성
mkdir -p /home/ubuntu/apps
mkdir -p /home/ubuntu/script

cd /home/ubuntu/apps
curl https://nginx.org/download/nginx-1.26.0.tar.gz > nginx.tgz
tar -zxvf nginx.tgz

echo "Entrypoint script completed"

