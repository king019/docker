#!/bin/bash
set -x

#rock 9
sed -i 's/dl-cdn.alpinelinux.org/nexus:8081\/repository\/alpine/g' /etc/apk/repositories