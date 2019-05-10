#!/bin/bash
set -x
service mongodb start
yapi server
tail -f /docker.sh

