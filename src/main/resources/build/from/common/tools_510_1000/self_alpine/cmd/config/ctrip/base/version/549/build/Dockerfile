FROM  king019/alpine:jdk8 as pre

MAINTAINER king019

DKCONFIG multi_run_cmd soft_apollo_pre


FROM  king019/alpine:jdk8

DKCONFIG multi_run_cmd soft_apollo_next


RUN chmod 755 /*.sh

CMD /docker.sh
