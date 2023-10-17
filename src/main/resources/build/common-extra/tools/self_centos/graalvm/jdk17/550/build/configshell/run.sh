#!/bin/bash
set -x
echo $jarName
source /etc/profile
cd /opt/soft
native-image -jar  /opt/soft/$jarName.jar /opt/soft/$jarName
ls
/opt/soft/$jarName