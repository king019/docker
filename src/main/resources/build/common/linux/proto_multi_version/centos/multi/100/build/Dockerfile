FROM king019/centos:p

MAINTAINER king019


COPY settings.xml /root/.m2/settings.xml
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh
COPY run/profile.sh /profile.sh
COPY run/git.sh /opt/soft/git.sh
# COPY run/protoc.sh /protoc.sh
# COPY run/perf.sh /perf.sh
COPY run/mvnclean.sh /mvnclean.sh

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




RUN dnf -y install  maven
RUN dnf -y install  java-11-openjdk-devel
RUN dnf -y install  java-1.8.0-openjdk-devel
RUN dnf -y install  git
RUN dnf -y install  curl
RUN dnf -y install  wget
RUN dnf -y install  vim
RUN dnf -y install  nodejs
RUN npm config set registry https://registry.npm.taobao.org
RUN dnf -y install  nginx
RUN dnf -y install  gdb
RUN dnf -y install  strace
RUN dnf -y --enablerepo=powertools install protobuf-devel
RUN dnf -y install  perf
#python

RUN dnf -y install  python2
RUN echo "alias python='python2'" >> /etc/profile
RUN echo "alias pip='pip2'" >> /etc/profile



RUN dnf -y install  net-tools
RUN dnf -y install  unzip
RUN dnf -y install  which
RUN dnf -y install  lsof
RUN dnf -y install  traceroute


RUN dnf -y install  telnet

RUN dnf -y install  redis
#base
#放入extra
RUN chmod -R 777 /*.sh
RUN /protoc.sh
# RUN /perf.sh
RUN /mvnclean.sh

#RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc


#nodejs
#RUN curl --silent --location https://rpm.nodesource.com/setup_12.x | bash -
#RUN yum -y install nodejs
#ADD https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.94/bin/apache-tomcat-7.0.94.tar.gz /opt/soft/apache-tomcat-7.0.94.tar.gz



ADD http://maven.aliyun.com/repository/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/tools/jetty-distribution-9.4.19.v20190610.tar.gz
ADD http://maven.aliyun.com/repository/public/org/apache/tomcat/tomcat/8.5.66/tomcat-8.5.66.tar.gz /opt/soft/tools/tomcat-8.5.66.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.19.v20190610.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.19.v20190610 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-8.5.66.tar.gz;ls
RUN cd /opt/soft/tools;mv apache-tomcat-8.5.66 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




#RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /root/.bashrc
#RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /root/.bashrc

# RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /etc/profile
# RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /etc/profile

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile


RUN cd /opt/soft ; sh ./git.sh


COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json


COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
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
