#!/bin/bash
set -x
NowPlatform=$(uname -m)
X86='x86_64'
Arm='aarch64'
if [[ $NowPlatform == $X86 ]]
then
ln -s /usr/lib/jvm/java-8-openjdk-amd64  /usr/lib/jvm/openjdk-8
else [[ $NowPlatform == $Arm ]]
ln -s /usr/lib/jvm/java-8-openjdk-arm64  /usr/lib/jvm/openjdk-8
fi
