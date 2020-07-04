#!/bin/sh
set -x

cd /root/tools/conf/7001/
redis-server redis7001.conf
cd /root/tools/conf/7002/
redis-server redis7002.conf
cd /root/tools/conf/7003/
redis-server redis7003.conf
cd /root/tools/conf/7004/
redis-server redis7004.conf
cd /root/tools/conf/7005/
redis-server redis7005.conf
cd /root/tools/conf/7006/
redis-server redis7006.conf
cd /root/tools/conf/7007/
redis-server redis7007.conf
cd /root/tools/conf/7008/
redis-server redis7008.conf
cd /root/tools/conf/7009/
redis-server redis7009.conf



redis-cli --cluster create 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 127.0.0.1:7006 127.0.0.1:7007 127.0.0.1:7008 127.0.0.1:7009 --cluster-replicas 2

#./src/redis-trib.rb create --replicas 2 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 127.0.0.1:7006 127.0.0.1:7007 127.0.0.1:7008 127.0.0.1:7009



tail -f /docker.sh