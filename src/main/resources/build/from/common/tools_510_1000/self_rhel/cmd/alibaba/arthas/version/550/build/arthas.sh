#!/bin/sh
set -x
javah -version
source /etc/profile;java -version
cd ${WS}/arthas
java -jar ${WS}/arthas/arthas-boot.jar
