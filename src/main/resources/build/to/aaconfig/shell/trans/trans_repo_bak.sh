#!/bin/bash
set -x

sed -i 's/http/https/g' /etc/apk/repositories
sed -i 's/mirrors.aliyun.com/dl-cdn.alpinelinux.org/g' /etc/apk/repositories
