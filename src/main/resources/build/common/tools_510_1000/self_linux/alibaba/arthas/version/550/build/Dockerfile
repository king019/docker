FROM  king019/linux:jdk17

MAINTAINER king019
RUN alias javah=/usr/lib/jvm/java-1.8-openjdk/bin/javah
COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
COPY sshm.sh /sshm.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN /sshm.sh
CMD /docker.sh
