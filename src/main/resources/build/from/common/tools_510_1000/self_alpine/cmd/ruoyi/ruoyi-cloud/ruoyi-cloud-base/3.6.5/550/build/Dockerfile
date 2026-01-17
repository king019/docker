FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

DKCONFIG multi_run_cmd soft_ruoyi_cloud_pre
FROM  king019/alpine:jdk8




COPY dkrun.sh /dkrun.sh
DKCONFIG multi_run_cmd soft_ruoyi_cloud_next
RUN chmod 755 /*.sh



EXPOSE 8080


CMD /docker.sh



