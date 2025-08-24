FROM  king019/linux:jdk

MAINTAINER king019
ENV arthas_version=4.0.5


RUN alias javah=/usr/lib/jvm/java-1.8-openjdk/bin/javah
COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh




FROM  king019/linux:jdk8
COPY --from=pre /opt/soft/tool/tomcat/webapps/ROOT.war /opt/soft/tool/tomcat/webapps/ROOT.war
COPY dkrun.sh /dkrun.sh
COPY dkrun.sh /dkrun.sh
COPY arthas.sh /arthas.sh
COPY sshm.sh /sshm.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
RUN /sshm.sh
CMD /docker.sh