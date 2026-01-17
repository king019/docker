#!/bin/sh
set -x
nohup redis-server &


/exporter.sh
