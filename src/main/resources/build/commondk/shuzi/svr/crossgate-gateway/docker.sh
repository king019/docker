#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd gateway
mvn install
cd crossgate-gateway


sed -i "s/\"GatewayRoute\"/\"com.lex.crossgate.system.domain.GatewayRoute\"/g" src/main/resources/mapper/*.xml
sed -i "s/\"SysUrlLog\"/\"com.lex.crossgate.system.domain.SysUrlLog\"/g" src/main/resources/mapper/*.xml
sed -i "s/\"SysUrl\"/\"com.lex.crossgate.system.domain.SysUrl\"/g" src/main/resources/mapper/*.xml
sed -i "s/\"SysUrlInfo\"/\"com.lex.crossgate.system.domain.SysUrlInfo\"/g" src/main/resources/mapper/*.xml

mvn spring-boot:run -T 100
tail -f /docker.sh
