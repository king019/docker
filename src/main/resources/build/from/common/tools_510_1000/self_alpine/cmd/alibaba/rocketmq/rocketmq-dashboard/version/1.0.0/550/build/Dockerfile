FROM king019/alpine:jdk8 as pre

MAINTAINER king019
DKCONFIG multi_run_cmd soft_rocketmq_dashboard_pre



FROM king019/alpine:jdk8
DKCONFIG multi_run_cmd soft_rocketmq_dashboard_next

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh





