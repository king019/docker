#!/bin/bash
no ok

git clone https://gitee.com/king019/gogs.git
docker build -f ./docker/Dockerfile.aarch64 -t registry.cn-beijing.aliyuncs.com/king019/gogs .

docker push registry.cn-beijing.aliyuncs.com/king019/gogs
