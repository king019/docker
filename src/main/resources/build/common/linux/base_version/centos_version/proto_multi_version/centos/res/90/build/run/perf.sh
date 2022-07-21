#!/bin/bash
set -x
mkdir -p /root/soft/perf-result/
mkdir -p /opt/soft/compile/
cd /opt/soft/compile/

export LD_PRELOAD=/usr/local/lib/libtcmalloc.so
export HEAPPROFILE=/root/soft/perf-result/
export HEAP_PROFILE_ALLOCATION_INTERVAL=2000000000

git clone https://gitee.com/mirrors/gperftools.git
cd gperftools
./autogen.sh
./configure
make
make install
cd /
 pprof -v
