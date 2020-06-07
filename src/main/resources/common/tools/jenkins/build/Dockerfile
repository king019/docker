FROM  king019/alpine

MAINTAINER king019
RUN apk add ttf-dejavu
#RUN apk add docker
RUN mkdir -p /opt/soft
RUN mkdir -p /root/tools/
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz /opt/soft/apache-tomcat-9.0.35.tar.gz
ADD https://mirrors.huaweicloud.com/jenkins/war/latest/jenkins.war /opt/soft/jenkins.war


RUN cp /opt/soft/apache-tomcat-9.0.35.tar.gz /root/tools/apache-tomcat-9.0.35.tar.gz
RUN cp /opt/soft/jenkins.war /root/tools/jenkins.war
RUN cd /root/tools/;tar -xzf apache-tomcat-9.0.35.tar.gz
RUN cd /root/tools/;mv apache-tomcat-9.0.35 tomcat
RUN cd /root/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /root/tools/tomcat/webapps

RUN cp /opt/soft/jenkins.war  /root/tools/tomcat/webapps/ROOT.war


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
