FROM king019/rhel:res

MAINTAINER king019


RUN dnf -y install  maven
RUN cp /usr/share/maven/bin/mvn /usr/share/maven/bin/mvn.bak


DKCONFIG multi_run_cmd rhel_jdk

RUN chmod 755 /*.sh
CMD /docker.sh
