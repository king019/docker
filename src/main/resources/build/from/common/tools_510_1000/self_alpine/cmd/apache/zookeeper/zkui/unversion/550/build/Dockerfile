FROM  king019/alpine:jdk8 as pre

MAINTAINER king019
DKCONFIG multi_run_cmd soft_zookeeper_ui_pre
FROM  king019/alpine:jdk8
COPY dkrun.sh /dkrun.sh
COPY config.cfg ${WS}/config.cfg

DKCONFIG multi_run_cmd soft_zookeeper_ui_next


RUN chmod 755 /*.sh



CMD /docker.sh
