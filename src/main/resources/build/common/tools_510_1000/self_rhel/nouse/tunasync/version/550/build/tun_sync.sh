#!/bin/bash
set -x
cd /opt/soft/tunasync/
NowPlatform=$(uname -m)
X86='x86_64'
Arm='aarch64'
if [[ $NowPlatform == $X86 ]]
then
  tar -xzf ./tunasync-linux-amd64-bin.tar.gz
else [[ $NowPlatform == $Arm ]]
  tar -xzf ./tunasync-linux-arm64-bin.tar.gz
fi
