FROM  king019/ruoyi:cloud_base_3.6.5 as pre



FROM  king019/alpine:jdk8
MAINTAINER king019
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh



COPY --from=pre ${WS}/ruoyi-modules-system.jar ${WS}

EXPOSE 8080


CMD /docker.sh



