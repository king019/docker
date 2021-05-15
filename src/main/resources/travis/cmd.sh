#!/bin/sh
set -x
mvn compile exec:java -Dexec.mainClass="com.k.docker.jenkins.JenkinsBuildShell" -Dexec.args="ws=/root/soft/docker@thread=20@rep=false@push=true@in=centos"
ls
sh ./target/x86_64_true.sh
