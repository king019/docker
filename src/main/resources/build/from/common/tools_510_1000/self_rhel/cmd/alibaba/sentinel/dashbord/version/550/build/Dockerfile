FROM  king019/alpine:jdk as pre

MAINTAINER king019

DKCONFIG multi_run_cmd soft_sentinel_pre
FROM  king019/alpine:jdk

DKCONFIG multi_run_cmd soft_sentinel_next

COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh
