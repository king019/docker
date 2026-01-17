#!/bin/sh
set -x
source /etc/profile;java -version


cd ${WS}

wget https://mirrors.huaweicloud.com/jenkins/war-stable/2.516.2/jenkins.war


cp ${WS}/jenkins.war ${WS}/tomcat/webapps/ROOT.war
