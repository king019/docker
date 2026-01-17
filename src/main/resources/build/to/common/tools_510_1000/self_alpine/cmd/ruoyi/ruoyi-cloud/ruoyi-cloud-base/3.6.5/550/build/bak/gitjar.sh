#!/bin/sh
set -x

source /etc/profile;java -version

ruoyi_version=3.6.5

cd ${WS}
git clone https://gitee.com/y_project/RuoYi-Cloud.git
cd RuoYi-Cloud
git checkout v${ruoyi_version}


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
cd ../..

mvn package
#├── ruoyi-ui              // 前端框架 [80]
#├── ruoyi-gateway         // 网关模块 [8080]
#├── ruoyi-auth            // 认证中心 [9200]
#│       └── ruoyi-system                              // 系统模块 [9201]
#│       └── ruoyi-gen                                 // 代码生成 [9202]
#│       └── ruoyi-job                                 // 定时任务 [9203]
#│       └── ruoyi-file                                // 文件服务 [9300]
#ruoyi-visual-monitor                      // 监控中心 [9100]
find . -name ruoyi-gateway.jar  | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-auth.jar  | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-modules-system.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-modules-gen.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-modules-job.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-modules-file.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
find . -name ruoyi-visual-monitor.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh









