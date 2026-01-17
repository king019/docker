FROM king019/debian:m as pre

MAINTAINER king019

DKCONFIG multi_run_cmd server_pre
FROM king019/debian:m
DKCONFIG multi_run_cmd server_next
RUN chmod 755 /*.sh
CMD /docker.sh