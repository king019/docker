FROM king019/alpine:jdk as pre

MAINTAINER king019

DKCONFIG multi_run_cmd server_pre

FROM king019/alpine:jdk
DKCONFIG multi_run_cmd server_next

RUN chmod 755 /*.sh
CMD /docker.sh
