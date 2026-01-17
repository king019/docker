FROM  king019/almalinux:p9 as pre

MAINTAINER king019

DKCONFIG multi_run_cmd dir_all

DKCONFIG multi_run_cmd rhel_git

DKCONFIG multi_run_cmd rhel_jdk8
DKCONFIG multi_run_cmd rhel_install_unzip
DKCONFIG multi_run_cmd soft_nexus_pre

DKCONFIG multi_run_cmd mirror_nexus


FROM  king019/alpine:jdk8

DKCONFIG multi_run_cmd soft_nexus_next

COPY dkrun.sh /dkrun.sh

RUN chmod 755 /*.sh
CMD /docker.sh
