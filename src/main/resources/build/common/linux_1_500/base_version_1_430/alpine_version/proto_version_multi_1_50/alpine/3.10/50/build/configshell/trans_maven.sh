#!/bin/bash
set -x
sed -i 's/repo.huaweicloud.com/nexus:8081/g' /root/.m2/settings.xml