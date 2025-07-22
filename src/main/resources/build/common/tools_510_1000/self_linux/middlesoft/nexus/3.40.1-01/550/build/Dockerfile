FROM  king019/linux:jdk8 as pre

MAINTAINER king019


ENV nexus_version=3.40.1-01

COPY gitjar.sh /gitjar.sh

RUN chmod 755 /*.sh
RUN /gitjar.sh









FROM  king019/linux:jdk8



COPY --from=pre /opt/soft/nexus-base-template-${nexus_version}.zip /opt/soft/nexus-base-template-${nexus_version}.zip



COPY dkrun.sh /dkrun.sh

COPY gitNext.sh /gitNext.sh
RUN chmod 755 /*.sh
RUN /gitNext.sh
CMD /docker.sh
