#!/bin/bash
# 디버그가 어려운 단점

echo "Starting entrypoint script"

# 업데이트 및 패키지 설치
apt-get update
apt-get install -y build-essential libpcre3 libpcre3-dev zlib1g-dev libssl-dev
apt-get install -y curl

# 디렉터리 생성
mkdir -p /home/ubuntu/apps
mkdir -p /home/ubuntu/apps/front
mkdir -p /home/ubuntu/script
mkdir -p /home/ubuntu/conf
mkdir -p /home/ubuntu/logs
mkdir -p /home/ubuntu/run

cd /home/ubuntu/apps
curl https://nginx.org/download/nginx-1.26.0.tar.gz > nginx.tgz
tar -zxvf nginx.tgz

mv nginx-1.26.0 nginx

cp nginx/conf/nginx.conf /home/ubuntu/conf/

cd nginx
./configure --prefix=/home/ubuntu/apps/nginx --pid-path=/home/ubuntu/run/nginx.pid --conf-path=/home/ubuntu/conf/nginx/nginx.conf --error-log-path=/home/ubuntu/logs/nginx/error.log --http-log-path=/home/ubuntu/logs/nginx/access.log --with-http_ssl_module --with-stream --with-http_realip_module --with-http_stub_status_module --with-http_gzip_static_module --with-http_v2_module --with-stream_realip_module

make
make install

echo 'export PATH=$PATH:/home/ubuntu/apps/nginx/sbin' >> ~/.bash_profile
source ~/.bash_profile

nginx -v

cp -r /home/ubuntu/apps/front/** /home/ubuntu/apps/nginx/html

cd /home/ubuntu/apps/nginx/sbin

./nginx
./nginx -s reload


tail -f /dev/null
