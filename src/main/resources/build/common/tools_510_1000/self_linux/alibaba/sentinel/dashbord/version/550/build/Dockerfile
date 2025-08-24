FROM  king019/linux:jdk as pre

MAINTAINER king019

COPY gitjar.sh /gitjar.sh
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh










FROM  king019/linux:jdk
COPY --from=pre /opt/soft/sentinel-dashboard.jar /opt/soft/sentinel-dashboard.jar
COPY dkrun.sh /dkrun.sh
RUN chmod 755 /*.sh
CMD /docker.sh
