FROM  king019/alpine:jdk

MAINTAINER king019
DKCONFIG multi_run_cmd soft_arthas_pre

COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
#COPY sshm.sh /sshm.sh
RUN chmod 755 /*.sh
#RUN /sshm.sh
CMD /docker.sh