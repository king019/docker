#!/bin/bash
set -x
dnf install -y autoconf automake libtool curl make gcc-c++ unzip
mkdir -p /opt/soft/compile
cd /opt/soft/compile

git clone https://gitee.com/mirrors/protobufsource.git protobuf
cd protobuf
./autogen.sh
./configure --prefix=/usr
make
make install
cd /
protoc --version
