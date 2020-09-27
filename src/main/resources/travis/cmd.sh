#!/bin/sh
set -x
mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=5@rep=false@push=true@rg=dk"
sh ./target/x86_64_docker_true.sh
