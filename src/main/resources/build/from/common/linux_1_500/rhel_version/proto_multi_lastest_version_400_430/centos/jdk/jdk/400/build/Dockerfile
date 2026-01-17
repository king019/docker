FROM  king019/rhel:b as pre

MAINTAINER king019

DKCONFIG multi_run_cmd rhel_jdk
DKCONFIG multi_run_cmd server_pre
FROM  king019/rhel:b
DKCONFIG multi_run_cmd rhel_jdk
DKCONFIG multi_run_cmd server_next



RUN chmod 755 /*.sh
CMD /docker.sh
