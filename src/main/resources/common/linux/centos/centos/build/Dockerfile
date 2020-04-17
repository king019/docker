FROM king019/centos:p

MAINTAINER king019

COPY settings.xml /root/.m2/settings.xml
COPY run.sh /run.sh
COPY run_env.sh /run_env.sh

#RUN yum list|sed -n '7,1111111p' |awk '{print "yum -y install  " $1}'
#可以使用临时关闭
#RUN sed -i "s/#baseurl/baseurl/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s/mirrorlist=http/#mirrorlist=http/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s@http://mirror.centos.org@https://mirrors.huaweicloud.com@g" /etc/yum.repos.d/CentOS-Base.repo

#RUN yum -y install wget
#RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.huaweicloud.com/repository/conf/CentOS-AltArch-7.repo
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo

RUN yum clean all
RUN yum makecache

RUN yum -y update
#base

RUN yum -y install  java-1.8.0-openjdk-devel  java-11-openjdk-devel

RUN yum -y install  git wget net-tools unzip which traceroute lsof vim telnet
#base
#RUN yum -y install   maven
RUN yum -y install  automake make gcc-c++ boost-devel git wget hg

RUN yum -y install  net-tools unzip which openssh-server openssh-clients go logrotate socat

#RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc

RUN yum -y install  traceroute lsof sysstat mercurial

RUN mkdir -p /opt/soft/tool

RUN cd /opt/soft/tool
#nodejs
#RUN curl --silent --location https://rpm.nodesource.com/setup_12.x | bash -
#RUN yum -y install nodejs

#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.22/bin/apache-tomcat-9.0.22.tar.gz /opt/soft/apache-tomcat-9.0.22.tar.gz

#ADD https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.43/bin/apache-tomcat-8.5.43.tar.gz /opt/soft/apache-tomcat-8.5.43.tar.gz

#ADD https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.94/bin/apache-tomcat-7.0.94.tar.gz /opt/soft/apache-tomcat-7.0.94.tar.gz

ADD http://maven.aliyun.com/nexus/content/groups/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/jetty-distribution-9.4.19.v20190610.tar.gz

ADD https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz /opt/soft/apache-maven-3.6.3-bin.tar.gz

RUN cd /opt/soft/tool;tar -xzf apache-maven-3.6.3-bin.tar.gz

RUN mv /opt/soft/tool/apache-maven-3.6.3 /opt/soft/tool/maven

RUN echo 'export MAVEN_HOME=/opt/soft/maven' >> /root/.bashrc
RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /root/.bashrc

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile



RUN echo '/run.sh' >> /etc/rc.local




COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
#RUN curl -H "Content-Type: application/json" --data '{"build": true}' -X POST https://registry.hub.docker.com/u/king019/centos7/trigger/d72d64e6-ba5e-4d71-acc8-98c10ead59db/
CMD /docker.sh

EXPOSE 21
EXPOSE 22
EXPOSE 3128
EXPOSE 443
EXPOSE 4000
EXPOSE 7000
EXPOSE 80
EXPOSE 888
EXPOSE 8000
EXPOSE 8080
EXPOSE 8081
EXPOSE 8443
EXPOSE 8563
EXPOSE 8888
EXPOSE 9876
EXPOSE 10909
EXPOSE 10911
