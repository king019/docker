#!/bin/sh
set -x
SHARED_DIRECTORY=/opt/soft/data
/nfsd.sh
tail -f /docker.sh
