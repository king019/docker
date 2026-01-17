#!/bin/sh
set -x

cd ${WS}/dubbo-admin/dubbo-admin-ui
npm run dev

tail -f /docker.sh
