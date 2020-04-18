#!/bin/bash
set -x
chmod 755 /*.sh
/run_env.sh
echo 'run_env' > /opt/soft/run_notich.txt