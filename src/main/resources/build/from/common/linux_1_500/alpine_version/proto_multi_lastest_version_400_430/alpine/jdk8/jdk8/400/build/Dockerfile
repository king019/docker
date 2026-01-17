FROM  king019/alpine:b as pre

MAINTAINER king019



DKCONFIG multi_run_cmd alphne_jdk8
DKCONFIG multi_run_cmd server8_pre

FROM  king019/alpine:b

DKCONFIG multi_run_cmd alphne_jdk8
DKCONFIG multi_run_cmd server8_next



RUN chmod 755 /*.sh
CMD /docker.sh
