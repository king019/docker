#!/bin/sh
set -x

echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-shanghai.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-huhehaote.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-shenzhen.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-hangzhou.aliyuncs.com --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-beijing.aliyuncs.com --password-stdin





mkdir -p /root/soft
cd /root/soft
git clone https://github.com/king019/docker.git
cd docker
mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=1@rep=false@push=true"
sh ./target/x86_64_docker_true.sh



tail -f /docker.sh