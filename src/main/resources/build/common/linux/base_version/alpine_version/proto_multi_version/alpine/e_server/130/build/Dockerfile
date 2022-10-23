FROM king019/alpine:m

MAINTAINER king019

ADD https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.49.v20220914/jetty-distribution-9.4.49.v20220914.tar.gz /opt/soft/tools/jetty-distribution-9.4.49.v20220914.tar.gz
ADD https://repo1.maven.org/maven2/org/apache/tomcat/tomcat/9.0.68/tomcat-9.0.68.tar.gz /opt/soft/tools/tomcat-9.0.68.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.49.v20220914.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.49.v20220914 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-9.0.68.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-9.0.68 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




CMD /docker.sh
