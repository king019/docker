FROM  king019/alpine:ex as pre

MAINTAINER king019


DKCONFIG multi_run_cmd alphne_jdk
DKCONFIG multi_run_cmd server_pre
FROM  king019/alpine:ex
DKCONFIG multi_run_cmd alphne_jdk
DKCONFIG multi_run_cmd server_next




RUN chmod 755 /*.sh
CMD /docker.sh
