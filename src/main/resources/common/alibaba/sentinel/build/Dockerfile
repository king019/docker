FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD https://github.com/alibaba/Sentinel/releases/download/1.7.2/sentinel-dashboard-1.7.2.jar /opt/soft/sentinel-dashboard-1.7.2.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/sentinel-dashboard-1.7.2.jar /root/tools/sentinel-dashboard-1.7.2.jar
RUN cd /root/tools; mv sentinel-dashboard-1.7.2.jar  sentinel-dashboard.jar

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
