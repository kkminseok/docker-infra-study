docker run -it -d --name proxyServer --cpuset-cpus=1 --memory 1G \
  -v /Users/kms/Code/2024.05.study/shell/nginx/proxy-init-script.sh:/usr/local/bin/entrypoint.sh \
  -v /Users/kms/Code/2024.05.study/shell/nginx/nginx-setting.sh:/home/ubuntu/shell \
  --entrypoint /usr/local/bin/entrypoint.sh \
  ubuntu
