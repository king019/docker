FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD https://github.com/alibaba/Sentinel/releases/download/v1.8.0/sentinel-dashboard-1.8.0.jar /opt/soft/sentinel-dashboard-1.8.0.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/sentinel-dashboard-1.8.0.jar /root/tools/sentinel-dashboard-1.8.0.jar
RUN cd /root/tools; mv sentinel-dashboard-1.8.0.jar  sentinel-dashboard.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
