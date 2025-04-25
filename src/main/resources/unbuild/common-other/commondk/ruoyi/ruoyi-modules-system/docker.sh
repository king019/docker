#!/bin/sh
set -x
source /etc/profile;echo ''


cd /opt/soft/version
cd RuoYi-Cloud
mvn install
cd ruoyi-modules/ruoyi-system

sed -i "s/\"SysConfig\"/\"com.ruoyi.system.domain.SysConfig\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysDept\"/\"com.ruoyi.system.api.domain.SysDept\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysDictData\"/\"com.ruoyi.system.api.domain.SysDictData\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysDictType\"/\"com.ruoyi.system.api.domain.SysDictType\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysLogininfor\"/\"com.ruoyi.system.api.domain.SysLogininfor\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysMenu\"/\"com.ruoyi.system.domain.SysMenu\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysNotice\"/\"com.ruoyi.system.domain.SysNotice\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysOperLog\"/\"com.ruoyi.system.api.domain.SysOperLog\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysPost\"/\"com.ruoyi.system.domain.SysPost\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysRoleDept\"/\"com.ruoyi.system.domain.SysRoleDept\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysRole\"/\"com.ruoyi.system.api.domain.SysRole\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysRoleMenu\"/\"com.ruoyi.system.domain.SysRoleMenu\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysUser\"/\"com.ruoyi.system.api.domain.SysUser\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysUserPost\"/\"com.ruoyi.system.domain.SysUserPost\"/g" src/main/resources/mapper/system/*.xml
sed -i "s/\"SysUserRole\"/\"com.ruoyi.system.domain.SysUserRole\"/g" src/main/resources/mapper/system/*.xml


cat src/main/resources/mapper/system/*.xml
mvn spring-boot:run -T 100
tail -f /docker.sh
