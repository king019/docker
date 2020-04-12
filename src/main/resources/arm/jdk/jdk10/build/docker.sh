#!/bin/bash
set -x

cd /op/soft/
tar -xzf apache-tomcat-9.0.24.tar.gz


cd /op/soft/
tar -xzf OpenJDK10U-jdk_arm_linux_hotspot_10.0.2_13.tar.gz
mv jdk-10.0.2+13.1 jdk

echo 'export JAVA_HOME=/opt/soft/jdk' >> /etc/profile
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile


source /etc/profile

tail -f /docker.sh
