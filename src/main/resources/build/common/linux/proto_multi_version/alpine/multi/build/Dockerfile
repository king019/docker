FROM king019/alpine:p

MAINTAINER king019

ADD bashrc /root/.bashrc

COPY settings.xml /root/.m2/settings.xml
COPY run/run.sh /run.sh
COPY run/run_env.sh /run_env.sh
COPY run/profile.sh /profile.sh
COPY run/git.sh /opt/soft/git.sh

COPY docker.sh /docker.sh

RUN apk add git
RUN apk add openjdk11
RUN apk add openjdk8
RUN apk add maven
RUN apk add curl
RUN apk add wget
RUN apk add vim
RUN apk add gnupg

#jenkins 需要这个
#RUN apk add ttf-dejavu
#nodejs
#RUN apk add nodejs
#RUN apk add npm
#RUN npm config set registry https://registry.npm.taobao.org

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

RUN mkdir -p /opt/soft/tools

RUN mkdir -p /root/soft/

RUN mkdir -p /root/tools

ADD http://maven.aliyun.com/nexus/content/groups/public/org/eclipse/jetty/jetty-distribution/9.4.19.v20190610/jetty-distribution-9.4.19.v20190610.tar.gz /opt/soft/tools/jetty-distribution-9.4.19.v20190610.tar.gz
ADD https://mirrors.huaweicloud.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz /opt/soft/tools/apache-tomcat-9.0.35.tar.gz


RUN cp /opt/soft/tools/jetty-distribution-9.4.19.v20190610.tar.gz  /root/tools/jetty-distribution-9.4.19.v20190610.tar.gz
RUN cd /root/tools/;tar -xzf jetty-distribution-9.4.19.v20190610.tar.gz
RUN cd /root/tools/;mv jetty-distribution-9.4.19.v20190610 jetty



RUN cp /opt/soft/tools/apache-tomcat-9.0.35.tar.gz  /root/tools/apache-tomcat-9.0.35.tar.gz
RUN cd /root/tools/;tar -xzf apache-tomcat-9.0.35.tar.gz
RUN cd /root/tools/;mv apache-tomcat-9.0.35 tomcat





RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-11-openjdk' >> /etc/profile

RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile




# 开放22端口
EXPOSE 22

RUN chmod 755 /*.sh


# 执行ssh启动命令
CMD ["/usr/sbin/sshd", "-D"]


CMD /docker.sh
