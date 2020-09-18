FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD http://nginxdown:9500/share_sentinel_apollo-1.0-SNAPSHOT.jar /opt/soft/share_sentinel_apollo-1.0-SNAPSHOT.jar
RUN mkdir -p /root/tools
RUN cp /opt/soft/share_sentinel_apollo-1.0-SNAPSHOT.jar /root/tools/share_sentinel_apollo-1.0-SNAPSHOT.jar

COPY docker.sh /docker.sh
COPY curlRun.sh /curlRun.sh
RUN chmod 755 /*.sh
CMD /docker.sh
