#!/bin/sh
set -x
mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=50@rep=false@push=true@rg=lc,bj"
sh ./target/x86_64_docker_true.sh
