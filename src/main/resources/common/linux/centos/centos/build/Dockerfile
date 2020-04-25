FROM king019/centos:p

MAINTAINER king019

RUN mkdir -p /root/soft
RUN mkdir -p /opt/soft

COPY settings.xml /root/.m2/settings.xml
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh
COPY run/profile.sh /profile.sh
COPY run/git.sh /opt/soft/git.sh

#RUN yum list|sed -n '7,1111111p' |awk '{print "yum -y install  " $1}'
#可以使用临时关闭
#RUN sed -i "s/#baseurl/baseurl/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s/mirrorlist=http/#mirrorlist=http/g" /etc/yum.repos.d/CentOS-Base.repo
#RUN sed -i "s@http://mirror.centos.org@https://mirrors.huaweicloud.com@g" /etc/yum.repos.d/CentOS-Base.repo

#RUN yum -y install wget
#RUN mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo https://mirrors.huaweicloud.com/repository/conf/CentOS-AltArch-7.repo
#RUN wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo

#RUN yum clean all
#RUN yum makecache
#RUN yum -y update
#base
#RUN yum -y install  maven
RUN yum -y install  java-11-openjdk-devel
RUN yum -y install  git
RUN yum -y install  wget
RUN yum -y install  net-tools
RUN yum -y install  unzip
RUN yum -y install  which
RUN yum -y install  traceroute
RUN yum -y install  lsof
RUN yum -y install  vim
RUN yum -y install  telnet
#base

RUN yum -y install  automake
RUN yum -y install  make
RUN yum -y install  gcc-c++
RUN yum -y install  boost-devel
RUN yum -y install  wget
RUN yum -y install  hg
RUN yum -y install  net-tools
RUN yum -y install  unzip
RUN yum -y install  which
RUN yum -y install  openssh-server
RUN yum -y install  openssh-clients
RUN yum -y install  go
RUN yum -y install  logrotate
RUN yum -y install  socat
RUN yum -y install  sysstat
RUN yum -y install  mercurial


#RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc


#nodejs
#RUN curl --silent --location https://rpm.nodesource.com/setup_12.x | bash -
#RUN yum -y install nodejs
#ADD https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.22/bin/apache-tomcat-9.0.22.tar.gz /opt/soft/apache-tomcat-9.0.22.tar.gz
#ADD https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.43/bin/apache-tomcat-8.5.43.tar.gz /opt/soft/apache-tomcat-8.5.43.tar.gz
#ADD https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.94/bin/apache-tomcat-7.0.94.tar.gz /opt/soft/apache-tomcat-7.0.94.tar.gz


ADD http://maven.aliyun.com/nexus/content/groups/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/tool/jetty-distribution-9.4.19.v20190610.tar.gz
ADD https://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz /opt/soft/tool/apache-maven-3.6.3-bin.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz /opt/soft/tool/apache-tomcat-9.0.24.tar.gz



RUN mkdir -p /opt/soft/tool
RUN cd /opt/soft/tool;tar -xzf apache-maven-3.6.3-bin.tar.gz
RUN mv /opt/soft/tool/apache-maven-3.6.3 /opt/soft/tool/maven

#RUN echo 'export MAVEN_HOME=/opt/soft/tool/maven' >> /root/.bashrc
#RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /root/.bashrc

RUN echo 'export MAVEN_HOME=/opt/soft/tool/maven' >> /etc/profile
RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /etc/profile

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile






RUN cd /opt/soft ; sh ./git.sh





#RUN echo '/run.sh' >> /etc/rc.local




COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
#RUN curl -H "Content-Type: application/json" --data '{"build": true}' -X POST https://registry.hub.docker.com/u/king019/centos7/trigger/d72d64e6-ba5e-4d71-acc8-98c10ead59db/
CMD /docker.sh

#RUN sh /etc/rc.local

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
