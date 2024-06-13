FROM registry.cn-qingdao.aliyuncs.com/king019/ubuntu
MAINTAINER king019


RUN echo 'source /etc/profile' >> /root/.bashrc


ENV DEBIAN_FRONTEND noninteractive

ENV TZ=Asia/Shanghai

RUN mkdir -p /root/.m2/repository
RUN mkdir -p /opt/soft/version
RUN mkdir -p /opt/soft/tool
RUN mkdir -p /root/.docker
RUN mkdir -p /etc/docker

RUN sed -i "s@http://.*archive.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*security.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list
RUN sed -i "s@http://.*ports.ubuntu.com@http://repo.huaweicloud.com@g" /etc/apt/sources.list


RUN apt-get update
#RUN apt-get -y install expect



COPY docker.sh /docker.sh



#COPY configshell/expect_bash.sh /expect_bash.sh
COPY configshell/trans.sh /trans.sh
COPY configshell/trans_repo_bak.sh /trans_repo_bak.sh
COPY configshell/trans_repo_nexus.sh /trans_repo_nexus.sh
COPY configshell/trans_maven.sh /trans_maven.sh
COPY configshell/trans_repo.sh /trans_repo.sh




COPY config/settings.xml /root/.m2/settings.xml
RUN echo 'trans_maven'
ADD config/bashrc /root/.bashrc
COPY config/config.json /config.json
RUN mkdir -p /root/.docker;cp /config.json /root/.docker/config.json
COPY config/daemon.json /daemon.json
RUN mkdir -p /etc/docker;cp /daemon.json /etc/docker/daemon.json



RUN chmod 755 /*.sh
#RUN /expect_bash.sh
#RUN source /etc/profile

CMD /docker.sh
