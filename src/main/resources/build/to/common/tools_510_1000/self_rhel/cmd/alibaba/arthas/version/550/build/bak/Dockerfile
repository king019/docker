FROM  king019/linux:jdk

MAINTAINER king019
ENV arthas_version=4.1.1


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
COPY sshm.sh /sshm.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
RUN source /etc/profile;chmod 755 /*.sh;/sshm.sh
CMD /docker.sh
