#!/bin/bash
set -x

cd /soft/
tar -xzf apache-tomcat-9.0.24.tar.gz

tail -f /docker.sh