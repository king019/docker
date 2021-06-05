FROM king019/alpine:p

MAINTAINER king019

ADD bashrc /root/.bashrc

COPY settings.xml /root/.m2/settings.xml
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh
COPY run/profile.sh /profile.sh
COPY run/git.sh /opt/soft/git.sh
COPY get-pip.py /opt/soft/get-pip.py
COPY run/mvnclean.sh /mvnclean.sh

COPY docker.sh /docker.sh


COPY config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json

COPY daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json








RUN apk add maven
RUN apk add openjdk11
RUN apk add openjdk8
RUN apk add git
RUN apk add curl
RUN apk add wget
RUN apk add vim
RUN apk add nginx
RUN apk add python2

RUN cd /opt/soft/;python get-pip.py


# telnet
RUN apk add busybox-extras


RUN apk add htop
RUN apk add strace
RUN apk add ttf-dejavu

RUN apk add redis


#RUN apk add --no-cache procps
#ps 增强
RUN apk add procps
#gnu
#RUN apk add gnupg

#jenkins 需要这个
#RUN apk add ttf-dejavu
#nodejs

RUN apk add  --repository https://mirrors.aliyun.com/alpine/v3.11/main/ nodejs=12.22.1-r0
RUN apk add  --repository https://mirrors.aliyun.com/alpine/v3.11/main/ npm=12.22.1-r0

RUN npm config set registry https://registry.npm.taobao.org





RUN apk add protoc






RUN /mvnclean.sh

# RUN apk update && \
#     apk add --no-cache openssh-server tzdata && \
#     cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
#     sed -i "s/#PermitRootLogin.*/PermitRootLogin yes/g" /etc/ssh/sshd_config && \
#     ssh-keygen -t rsa -P "" -f /etc/ssh/ssh_host_rsa_key && \
#     ssh-keygen -t ecdsa -P "" -f /etc/ssh/ssh_host_ecdsa_key && \
#     ssh-keygen -t ed25519 -P "" -f /etc/ssh/ssh_host_ed25519_key && \
#     echo "root:admin" | chpasswd
RUN set -x \
    apk update \
    && apk add --no-cache bash bash-doc bash-completion \
    && sed -i 's/ash/bash/g' /etc/passwd \
    && source /root/.bashrc



ADD http://maven.aliyun.com/repository/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/tools/jetty-distribution-9.4.19.v20190610.tar.gz
ADD http://maven.aliyun.com/repository/public/org/apache/tomcat/tomcat/8.5.66/tomcat-8.5.66.tar.gz /opt/soft/tools/tomcat-8.5.66.tar.gz


RUN cd /opt/soft/tools/;tar -xzf jetty-distribution-9.4.19.v20190610.tar.gz
RUN cd /opt/soft/tools/;mv jetty-distribution-9.4.19.v20190610 jetty


RUN cd /opt/soft/tools;tar -xzf tomcat-8.5.66.tar.gz;ls
RUN cd /opt/soft/tools;mv apache-tomcat-8.5.66 tomcat
RUN cd /opt/soft/tools/tomcat/webapps;rm -fr *
RUN mkdir -p /opt/soft/tools/tomcat/webapps




RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
