FROM  king019/alpine:ex as pre

MAINTAINER king019

DKCONFIG multi_run_cmd alphne_jdk8
DKCONFIG multi_run_cmd server8_pre

FROM  king019/alpine:ex

DKCONFIG multi_run_cmd alphne_jdk8
DKCONFIG multi_run_cmd server8_next








RUN chmod 755 /*.sh
CMD /docker.sh
