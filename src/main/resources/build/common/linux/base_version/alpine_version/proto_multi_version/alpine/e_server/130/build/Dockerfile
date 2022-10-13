FROM king019/alpine:m

MAINTAINER king019

ADD http://repo.huaweicloud.com/repository/maven/org/eclipse/jetty/jetty-distribution/9.4.45.v20220203/jetty-distribution-9.4.45.v20220203.tar.gz /opt/soft/tools/jetty-distribution-9.4.45.v20220203.tar.gz
ADD http://repo.huaweicloud.com/repository/maven/org/apache/tomcat/tomcat/8.5.75/tomcat-8.5.75.tar.gz /opt/soft/tools/tomcat-8.5.75.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.45.v20220203.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.45.v20220203 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-8.5.75.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-8.5.75 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




CMD /docker.sh
