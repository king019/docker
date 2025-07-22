FROM  king019/rhel:jdk8 as pre

MAINTAINER king019
ENV nacos_version=2.5.1

COPY gitjar.sh /gitjar.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


FROM  king019/linux:jdk8
ENV nacos_version=2.5.1


COPY --from=pre /opt/soft/nacos-server-${nacos_version}.zip /opt/soft/nacos-server-${nacos_version}.zip

COPY gitNext.sh /gitNext.sh



COPY dkrun.sh /dkrun.sh
COPY application.properties /application.properties
RUN chmod 755 /*.sh
RUN /gitNext.sh
CMD /docker.sh
