#!/bin/sh
set -x
baseurl=http://pushgateway:9091
curl -X PUT $baseurl/api/v1/admin/wipe