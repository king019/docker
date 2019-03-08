FROM  registry.cn-hangzhou.aliyuncs.com/king019/centos

MAINTAINER king019

ADD http://mirrors.shu.edu.cn/apache/rocketmq/4.4.0/rocketmq-all-4.4.0-source-release.zip /opt/soft/rocketmq-all-4.4.0-source-release.zip

RUN cd /opt/soft/;unzip rocketmq-all-4.4.0-source-release.zip;cd rocketmq-all-4.4.0/;mvn -Prelease-all -DskipTests clean install -U

COPY docker.sh /docker.sh
RUN chmod 755 /*.sh
CMD /docker.sh
