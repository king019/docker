#!/bin/sh
set -x
source /etc/profile
mkdir -p /opt/soft/version
cd /opt/soft/version
git clone https://github.com/torvalds/linux.git
