#!/bin/bash
set -x

cd /etc/yum.repos.d/
ls
rename repo.bak base *
rename repo nexus *
rename base repo *