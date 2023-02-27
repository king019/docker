#!/bin/bash
set -x


sed -i 's/http/https/g' /etc/apk/repositories
sed -i 's/dl-cdn.alpinelinux.org/nexus:8081\/repository\/alpine/g' /etc/apk/repositories
