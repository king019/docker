FROM  king019/alpine

MAINTAINER king019
#RUN apk add ttf-dejavu
#RUN apk add docker
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD https://mirrors.huaweicloud.com/jenkins/war/latest/jenkins.war /opt/soft/tools/jenkins.war
#ADD https://mirrors.huaweicloud.com/jenkins/war/2.242/jenkins.war /opt/soft/tools/jenkins.war

RUN cd /root/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /root/tools/tomcat/webapps

RUN cp /opt/soft/tools/jenkins.war  /root/tools/tomcat/webapps/ROOT.war


COPY docker.sh /docker.sh
COPY config.json /config.json
RUN mkdir /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir /etc/docker;cp /daemon.json /etc/docker/daemon.json


RUN chmod 755 /*.sh
CMD /docker.sh
