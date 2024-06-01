docker run -it -d --name proxyServer --cpuset-cpus=1 --memory 1G \
  -p 80:80 \
  -v $(pwd)/nginx/proxy-init-script.sh:/usr/local/bin/entrypoint.sh \
  -v $(pwd)/../front/vue-vite-hello-world/docker-front-test/dist:/home/ubuntu/apps/front \
  --entrypoint /usr/local/bin/entrypoint.sh \
  ubuntu:22.04 \
