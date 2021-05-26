#!/bin/sh
set -x

cd /opt/soft/conf/7001/
redis-server redis7001.conf
cd /opt/soft/conf/7002/
redis-server redis7002.conf
cd /opt/soft/conf/7003/
redis-server redis7003.conf
cd /opt/soft/conf/7004/
redis-server redis7004.conf
cd /opt/soft/conf/7005/
redis-server redis7005.conf
cd /opt/soft/conf/7006/
redis-server redis7006.conf
cd /opt/soft/conf/7007/
redis-server redis7007.conf
cd /opt/soft/conf/7008/
redis-server redis7008.conf
cd /opt/soft/conf/7009/
redis-server redis7009.conf



redis-cli --cluster create redisCluster:7001 redisCluster:7002 redisCluster:7003 redisCluster:7004 redisCluster:7005 redisCluster:7006 redisCluster:7007 redisCluster:7008 redisCluster:7009 --cluster-replicas 2

