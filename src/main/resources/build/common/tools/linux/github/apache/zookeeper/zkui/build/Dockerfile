FROM  king019/linux

MAINTAINER king019
RUN mkdir -p /opt/soft
ADD https://raw.githubusercontent.com/king019/save_github/master/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar /opt/soft/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar
COPY config.cfg /opt/soft/config.cfg
RUN mkdir -p /root/tools
RUN cp /opt/soft/config.cfg   /root/tools/config.cfg
RUN cp /opt/soft/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar   /root/tools/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
