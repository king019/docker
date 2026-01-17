FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

ENV ruoyi_cloud_version=v3.6.5
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER};git clone https://gitee.com/y_project/RuoYi-Cloud.git
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;git checkout ${ruoyi_cloud_version}
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysConfig\"/\"com.ruoyi.system.domain.SysConfig\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysDept\"/\"com.ruoyi.system.api.domain.SysDept\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysDictData\"/\"com.ruoyi.system.api.domain.SysDictData\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysDictType\"/\"com.ruoyi.system.api.domain.SysDictType\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysLogininfor\"/\"com.ruoyi.system.api.domain.SysLogininfor\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysMenu\"/\"com.ruoyi.system.domain.SysMenu\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysNotice\"/\"com.ruoyi.system.domain.SysNotice\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysOperLog\"/\"com.ruoyi.system.api.domain.SysOperLog\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysPost\"/\"com.ruoyi.system.domain.SysPost\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysRoleDept\"/\"com.ruoyi.system.domain.SysRoleDept\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysRole\"/\"com.ruoyi.system.api.domain.SysRole\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysRoleMenu\"/\"com.ruoyi.system.domain.SysRoleMenu\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysUser\"/\"com.ruoyi.system.api.domain.SysUser\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysUserPost\"/\"com.ruoyi.system.domain.SysUserPost\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud/ruoyi-modules/ruoyi-system;sed -i "s/\"SysUserRole\"/\"com.ruoyi.system.domain.SysUserRole\"/g" src/main/resources/mapper/system/*.xml
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;mvn package
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-gateway.jar  | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-auth.jar  | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-modules-system.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-modules-gen.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-modules-job.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-modules-file.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
RUN source /etc/profile;chmod 755 /*.sh;cd ${WS_VER}/RuoYi-Cloud;find . -name ruoyi-visual-monitor.jar | awk -v WS=${WS} '{print "cp " $1  " " WS}' | sh
FROM  king019/alpine:jdk8




COPY dkrun.sh /dkrun.sh
ENV ruoyi_cloud_version=v3.6.5
COPY --from=pre ${WS}/ruoyi-gateway.jar ${WS}/ruoyi-gateway.jar
COPY --from=pre ${WS}/ruoyi-auth.jar ${WS}/ruoyi-auth.jar
COPY --from=pre ${WS}/ruoyi-modules-system.jar ${WS}/ruoyi-modules-system.jar
COPY --from=pre ${WS}/ruoyi-modules-gen.jar ${WS}/ruoyi-modules-gen.jar
COPY --from=pre ${WS}/ruoyi-modules-job.jar ${WS}/ruoyi-modules-job.jar
COPY --from=pre ${WS}/ruoyi-modules-file.jar ${WS}/ruoyi-modules-file.jar
COPY --from=pre ${WS}/ruoyi-visual-monitor.jar ${WS}/ruoyi-visual-monitor.jar
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh



EXPOSE 8080


CMD /docker.sh



