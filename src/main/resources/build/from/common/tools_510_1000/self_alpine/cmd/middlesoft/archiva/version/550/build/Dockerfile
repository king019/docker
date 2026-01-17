FROM  king019/alpine:jdk8 as pre

MAINTAINER king019


DKCONFIG multi_run_cmd soft_archiva_pre

FROM  king019/alpine:jdk8
DKCONFIG multi_run_cmd soft_archiva_next
COPY dkrun.sh /dkrun.sh
COPY archiva.xml /archiva.xml
RUN chmod 755 /*.sh


CMD /docker.sh