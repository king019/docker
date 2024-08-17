#!/bin/sh
set -x
javah -version
source /etc/profile;java -version
cd /opt/soft/arthas
java -jar /opt/soft/arthas/arthas-boot.jar
