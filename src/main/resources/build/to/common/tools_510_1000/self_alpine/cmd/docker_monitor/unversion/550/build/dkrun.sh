#!/bin/sh
set -x
cd ${WS}
cd docker-mirror-monitor
python -m http.server 8000
