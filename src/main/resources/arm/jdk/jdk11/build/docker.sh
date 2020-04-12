#!/bin/bash
set -x

cd /opt/soft/
tar -xzf apache-tomcat-9.0.24.tar.gz


cd /opt/soft/
tar -xzf OpenJDK11U-jdk_arm_linux_hotspot_2020-04-09-17-31.tar.gz
mv jdk-11.0.7+9 jdk

echo 'export JAVA_HOME=/opt/soft/jdk' >> /etc/profile
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile


source /etc/profile

tail -f /docker.sh
