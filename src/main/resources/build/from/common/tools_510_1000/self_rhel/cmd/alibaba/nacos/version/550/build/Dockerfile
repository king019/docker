FROM  king019/rhel:jdk as pre

MAINTAINER king019
DKCONFIG multi_run_cmd soft_nacos_pre

FROM  king019/rhel:jdk

COPY application.properties /application.properties
COPY dkrun.sh /dkrun.sh

DKCONFIG multi_run_cmd soft_nacos_next




RUN chmod 755 /*.sh
CMD /docker.sh
