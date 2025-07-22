#!/bin/sh
set -x

cd /opt/soft/version/dubbo-admin/dubbo-admin-ui
npm run dev

tail -f /docker.sh
