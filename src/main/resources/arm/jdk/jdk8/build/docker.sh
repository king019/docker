#!/bin/bash
set -x

cd /opt/soft/
tar -xzf apache-tomcat-9.0.24.tar.gz

tail -f /docker.sh
