#!/bin/sh
set -x

source /etc/profile

java -version

mvn -version


echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
echo "$DOCKER_PASSWORD" | docker login -u "$ALIYUN_USERNAME" registry.cn-beijing.aliyuncs.com --password-stdin




mkdir -p /root/soft
cd /root/soft
git clone https://github.com/king019/docker.git
cd docker
chmod -R 777 .


mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=20@rep=false@push=true@in=centos"
ls
sh ./target/x86_64_true.sh