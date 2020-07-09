#!/bin/bash
set -x

source /etc/profile
java -version 2>&1 | sed '1!d' | sed -e 's/"//g' | awk '{print $3}' >> /opt/soft/notice.txt