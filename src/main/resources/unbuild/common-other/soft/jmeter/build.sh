#!/bin/sh
set -x
docker build -t  registry.cn-hangzhou.aliyuncs.com/king019/jmeter:jdk8 .
docker push registry.cn-hangzhou.aliyuncs.com/king019/jmeter:jdk8