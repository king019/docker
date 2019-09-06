#!/bin/bash
set -x

cd /soft/
tar -xzf openjdk-10_linux-x64_bin.tar.gz
mv jdk-10 jdk

echo 'export JAVA_HOME=/soft/jdk' >> /etc/profile
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile


source /etc/profile

tail -f /docker.sh
