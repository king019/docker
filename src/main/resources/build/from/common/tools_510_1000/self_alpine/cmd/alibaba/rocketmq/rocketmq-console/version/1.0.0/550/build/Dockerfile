FROM king019/alpine:jdk8 as pre

MAINTAINER king019

DKCONFIG multi_run_cmd soft_rocketmq_console_pre

FROM king019/alpine:jdk8
DKCONFIG multi_run_cmd soft_rocketmq_console_next
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh