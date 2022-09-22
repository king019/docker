FROM king019/fedora:jdk

MAINTAINER king019



RUN dnf -y install  git
RUN dnf -y install  wget
RUN dnf -y install  vim
RUN dnf -y install  nodejs
RUN npm config set registry https://registry.npm.taobao.org
RUN dnf -y install  nginx
RUN dnf -y install  gdb
RUN dnf -y install  strace
RUN dnf -y install protobuf-devel
RUN dnf -y install  perf
RUN dnf -y install go
RUN dnf -y install make
RUN dnf -y install autoconf
#python

RUN dnf -y install  python3
RUN echo "alias python='python3'" >> /etc/profile
RUN echo "alias pip='pip3'" >> /etc/profile



RUN dnf -y install  net-tools
RUN dnf -y install  unzip
RUN dnf -y install  which
RUN dnf -y install  lsof
RUN dnf -y install  traceroute


RUN dnf -y install  telnet

RUN dnf -y install  redis
RUN dnf -y install  rsync
RUN dnf -y install  gcc-c++
RUN dnf -y install  tcpdump













#base
#放入extra
RUN chmod -R 777 /*.sh
# RUN /protoc.sh
# RUN /perf.sh
#RUN /mvnclean.sh

#RUN yum -y install  zlib-devel rubygems ruby gem  ruby-devel ruby-docs ruby-ri ruby-irb ruby-rdoc


#nodejs
#RUN curl --silent --location https://rpm.nodesource.com/setup_12.x | bash -
#RUN yum -y install nodejs
#ADD https://archive.apache.org/dist/tomcat/tomcat-7/v7.0.94/bin/apache-tomcat-7.0.94.tar.gz /opt/soft/apache-tomcat-7.0.94.tar.gz



ADD http://repo.huaweicloud.com/repository/maven/org/eclipse/jetty/jetty-distribution/9.4.45.v20220203/jetty-distribution-9.4.45.v20220203.tar.gz /opt/soft/tools/jetty-distribution-9.4.45.v20220203.tar.gz
ADD http://repo.huaweicloud.com/repository/maven/org/apache/tomcat/tomcat/8.5.75/tomcat-8.5.75.tar.gz /opt/soft/tools/tomcat-8.5.75.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.45.v20220203.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.45.v20220203 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-8.5.75.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-8.5.75 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




#RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /root/.bashrc
#RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /root/.bashrc

# RUN echo 'export MAVEN_HOME=/opt/soft/tools/maven' >> /etc/profile
# RUN echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> /etc/profile



RUN cd /opt/soft ; sh ./git.sh

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
