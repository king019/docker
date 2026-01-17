#!/bin/sh
set -x
source /etc/profile;java -version
chmod -R 777 ${WS}
${WS}/archiva/bin/archiva
