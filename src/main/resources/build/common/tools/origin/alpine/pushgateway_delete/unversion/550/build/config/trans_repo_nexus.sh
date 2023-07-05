#!/bin/bash
set -x

#rock 9
sed -e 's|^mirrorlist=|#mirrorlist=|g'  -e 's|^#baseurl=http://dl.rockylinux.org/$contentdir|baseurl=http://nexus:8081/repository/rockylinux|g'  -i.bak /etc/yum.repos.d/rocky*.repo