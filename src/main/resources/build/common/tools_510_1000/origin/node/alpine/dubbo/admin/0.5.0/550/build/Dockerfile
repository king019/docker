FROM registry.cn-qingdao.aliyuncs.com/king019/node:12-alpine



RUN sed -i 's/https/http/g' /etc/apk/repositories
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories

RUN mkdir -p /root/.m2
RUN mkdir -p /opt/soft/tool/









RUN apk add git
RUN apk add wget
RUN apk add vim

RUN apk add maven
RUN apk add openjdk8

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk' >> /etc/profile
RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
RUN echo '#jdk8' >> /etc/profile

RUN npm config set registry http://registry.npmmirror.com
COPY file trans.sh
COPY file trans_repo_bak.sh
COPY file trans_repo_nexus.sh
COPY file trans_maven.sh
COPY file trans_repo.sh

COPY file settings.xml
COPY file mvnclean.sh


RUN echo 'trans_maven'

COPY gitjar.sh /gitjar.sh
COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
RUN /gitjar.sh
CMD /docker.sh