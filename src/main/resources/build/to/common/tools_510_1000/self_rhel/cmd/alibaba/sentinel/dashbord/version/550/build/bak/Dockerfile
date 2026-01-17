FROM  king019/linux:jdk as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
RUN source /etc/profile;chmod 755 /*.sh;/gitjar.sh
CMD /docker.sh




FROM  king019/linux:jdk
COPY --from=pre ${WS}/sentinel-dashboard.jar ${WS}/sentinel-dashboard.jar
COPY dkrun.sh /dkrun.sh
RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
CMD /docker.sh
