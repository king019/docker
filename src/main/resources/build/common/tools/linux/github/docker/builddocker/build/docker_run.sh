#!/bin/sh
set -x

source /etc/profile
mkdir -p /root/soft
cd /root/soft
git clone https://github.com/king019/docker.git
cd docker
source /etc/profile

mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=5@rep=false@push=true"
sh ./target/x86_64_true.sh
