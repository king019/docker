FROM  king019/centos

MAINTAINER king019
ADD https://mirrors.huaweicloud.com/jenkins/war/latest/jenkins.war /opt/soft/tools/jenkins.war
#ADD https://mirrors.huaweicloud.com/jenkins/war/2.242/jenkins.war /opt/soft/tools/jenkins.war

RUN cd /root/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /root/tools/tomcat/webapps

RUN cp /opt/soft/tools/jenkins.war  /root/tools/tomcat/webapps/ROOT.war


COPY docker.sh /docker.sh


RUN chmod 755 /*.sh
CMD /docker.sh
