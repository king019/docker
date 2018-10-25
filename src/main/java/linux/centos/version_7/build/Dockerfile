FROM  centos:7

MAINTAINER king019

RUN yum -y install  automake make gcc-c++ boost-devel git wget maven

RUN yum -y install  net-tools unzip which openssh-server openssh-clients go logrotate socat

RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc

RUN yum -y install  traceroute lsof sysstat

RUN mkdir -p /opt/soft

RUN cd /opt/soft

ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.8/bin/apache-tomcat-9.0.8.tar.gz /opt/soft/apache-tomcat-9.0.8.tar.gz
ADD https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.12.v20180830/jetty-distribution-9.4.12.v20180830.tar.gz /opt/soft/jetty-distribution-9.4.12.v20180830.tar.gz

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
EXPOSE 80
EXPOSE 8080
EXPOSE 22
EXPOSE 8000
EXPOSE 8443
EXPOSE 3128
EXPOSE 4000
EXPOSE 443
