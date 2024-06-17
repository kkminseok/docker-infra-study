docker run -i -t -d --name proxyServer-dockerfile --cpuset-cpus=1 --memory 1G \
 -p 80:80 proxyserver /bin/bash
