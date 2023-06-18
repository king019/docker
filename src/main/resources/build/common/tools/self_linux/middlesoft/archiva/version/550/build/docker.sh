#!/bin/sh
set -x
source /etc/profile;java -version
chmod -R 777 /opt/soft
/opt/soft/archiva/bin/archiva


tail -f /docker.sh
