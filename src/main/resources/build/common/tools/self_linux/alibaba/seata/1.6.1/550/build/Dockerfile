FROM  king019/linux:jdk8

MAINTAINER king019
COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
COPY sshm.sh /sshm.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN /sshm.sh
CMD /docker.sh
