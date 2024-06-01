FROM node:16-alpine as build-stage

COPY . .

RUN npm install
RUN npm run build

FROM ubuntu:22.04
WORKDIR /home/ubuntu

# 한 번에 실행하여 레이어 수 줄임
RUN mkdir -p /home/ubuntu/apps \
    /home/ubuntu/apps/front \
    /home/ubuntu/script \
    /home/ubuntu/conf \
    /home/ubuntu/logs \
    /home/ubuntu/run

COPY --from=0 /dist /home/ubuntu/apps/front

RUN apt-get update
RUN apt-get install -y build-essential libpcre3 libpcre3-dev zlib1g-dev libssl-dev
RUN apt-get install -y curl

WORKDIR /home/ubuntu/apps
RUN curl https://nginx.org/download/nginx-1.26.0.tar.gz -o nginx.tgz
RUN tar -zxvf nginx.tgz

RUN mv nginx-1.26.0 nginx

RUN cp nginx/conf/nginx.conf /home/ubuntu/conf/

WORKDIR /home/ubuntu/apps/nginx

RUN ./configure --prefix=/home/ubuntu/apps/nginx --pid-path=/home/ubuntu/run/nginx.pid --conf-path=/home/ubuntu/conf/nginx/nginx.conf --error-log-path=/home/ubuntu/logs/nginx/error.log --http-log-path=/home/ubuntu/logs/nginx/access.log --with-http_ssl_module --with-stream --with-http_realip_module --with-http_stub_status_module --with-http_gzip_static_module --with-http_v2_module --with-stream_realip_module

RUN make
RUN make install

RUN echo 'export PATH=$PATH:/home/ubuntu/apps/nginx/sbin' >> ~/.bashrc


RUN cp -r /home/ubuntu/apps/front/** /home/ubuntu/apps/nginx/html

WORKDIR  /home/ubuntu/apps/nginx/sbin


RUN echo "#!/bin/sh\nnginx -g 'daemon off;'" > /home/ubuntu/apps/nginx/sbin/run.sh && \
    chmod +x /home/ubuntu/apps/nginx/sbin/run.sh


CMD ["/home/ubuntu/apps/nginx/sbin/run.sh"]

