#!/bin/bash
set -x
cd /opt/soft/
java $JAVA_OPTS -jar frame_jvm_gc-1.0-SNAPSHOT.jar >>log.txt