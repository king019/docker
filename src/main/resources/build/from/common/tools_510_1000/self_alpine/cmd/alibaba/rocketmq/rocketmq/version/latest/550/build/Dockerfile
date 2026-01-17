FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

COPY dkrun.sh /dkrun.sh
DKCONFIG multi_run_cmd soft_rocketmq_pre
RUN chmod 755 /*.sh

FROM  king019/alpine:jdk8


DKCONFIG multi_run_cmd soft_rocketmq_next

COPY mqbroker_nouse.sh /mqbroker_nouse.sh
COPY mqnamesrv_nouse.sh /mqnamesrv_nouse.sh
RUN chmod 755 /*.sh
CMD /docker.sh