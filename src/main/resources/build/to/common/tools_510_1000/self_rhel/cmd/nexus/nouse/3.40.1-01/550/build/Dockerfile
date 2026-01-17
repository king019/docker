FROM  king019/alpine:jdk8 as pre

MAINTAINER king019


ENV nexus_version=3.40.1-01

COPY gitjar.sh /gitjar.sh

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh


FROM  king019/alpine:jdk8

COPY --from=pre ${WS}/nexus-base-template-${nexus_version}.zip ${WS}/nexus-base-template-${nexus_version}.zip



COPY dkrun.sh /dkrun.sh

COPY gitNext.sh /gitNext.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitNext.sh
CMD /docker.sh
