FROM  king019/linux:jdk

MAINTAINER king019
ENV arthas_version=4.1.1


COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
COPY sshm.sh /sshm.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN /sshm.sh
CMD /docker.sh