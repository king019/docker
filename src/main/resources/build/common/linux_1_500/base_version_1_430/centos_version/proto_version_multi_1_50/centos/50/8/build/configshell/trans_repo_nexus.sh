#!/bin/bash
set -x

sed -e 's|^baseurl=http://mirrors.openanolis.cn/|baseurl=http://nexus:8081/repository/openanolis/|g' -i.bak /etc/yum.repos.d/AnolisOS-*.repo