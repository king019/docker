FROM  king019/alpine

MAINTAINER king019
RUN mkdir -p /opt/soft
RUN mkdir -p /root/soft
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz /opt/soft/apache-tomcat-9.0.35.tar.gz
ADD https://mirrors.huaweicloud.com/jenkins/war/2.239/jenkins.war /opt/soft/jenkins.war


RUN cp /opt/soft/apache-tomcat-9.0.35.tar.gz /root/soft/apache-tomcat-9.0.35.tar.gz
RUN cp /opt/soft/jenkins.war /root/soft/jenkins.war
RUN cd /root/soft/;tar -xzf apache-tomcat-9.0.35.tar.gz
RUN cd /root/soft/;mv apache-tomcat-9.0.35 tomcat
RUN cd /root/soft/tomcat/webapps;rm -fr *
RUN mkdir -p /root/soft/tomcat/webapps

RUN cp /opt/soft/jenkins.war  /root/soft/tomcat/webapps/ROOT.war


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
