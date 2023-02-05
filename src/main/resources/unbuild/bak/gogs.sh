#!/bin/bash
no ok

git clone https://e.coding.net/king019/github/gogs.git
docker build -f ./docker/Dockerfile.aarch64 -t registry.cn-beijing.aliyuncs.com/king019/gogs .

docker push registry.cn-beijing.aliyuncs.com/king019/gogs
