FROM king019/alpine:jdk

MAINTAINER king019

RUN apk add curl
RUN apk add wget
RUN apk add vim
RUN apk add strace

# telnet
RUN apk add busybox-extras


RUN apk add htop
RUN apk add ttf-dejavu

RUN apk add tcpdump
RUN apk add procps



RUN chmod -R 777 /*.sh
RUN apk add bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc



ADD https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/9.4.45.v20220203/jetty-distribution-9.4.45.v20220203.tar.gz /opt/soft/tools/jetty-distribution-9.4.45.v20220203.tar.gz
ADD https://repo1.maven.org/maven2/org/apache/tomcat/tomcat/8.5.75/tomcat-8.5.75.tar.gz /opt/soft/tools/tomcat-8.5.75.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.45.v20220203.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.45.v20220203 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-8.5.75.tar.gz
RUN cd /opt/soft/tools;mv apache-tomcat-8.5.75 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
