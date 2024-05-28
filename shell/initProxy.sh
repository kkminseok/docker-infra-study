docker run -it -d --name proxyServer --cpuset-cpus=1 --memory 1G \
  -v ./nginx/proxy-init-script.sh:/usr/local/bin/entrypoint.sh \
  -v ./nginx/nginx-setting.sh:/home/ubuntu/shell \
  --entrypoint /usr/local/bin/entrypoint.sh \
  ubuntu
