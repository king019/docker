FROM  king019/linux

MAINTAINER king019

RUN apk add ttf-dejavu

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh


#ADD https://mirrors.huaweicloud.com/jenkins/war/latest/jenkins.war /opt/soft/tools/jenkins.war
#ADD https://mirrors.huaweicloud.com/jenkins/war/2.242/jenkins.war /opt/soft/tools/jenkins.war
ADD http://mirrors.huaweicloud.com/repository/maven/org/apache/tomcat/tomcat/10.0.2/tomcat-10.0.2.tar.gz /root/tools/tomcat-10.0.2.tar.gz
RUN cd /root/tools/;tar -xzf tomcat-10.0.2.tar.gz;mv apache-tomcat-10.0.2 tomcat
RUN cd /root/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /root/tools/tomcat/webapps

RUN cp /opt/soft/tools/jenkins.war  /root/tools/tomcat/webapps/ROOT.war

CMD /docker.sh
