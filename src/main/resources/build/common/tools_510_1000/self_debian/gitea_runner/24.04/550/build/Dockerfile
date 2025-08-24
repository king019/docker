FROM king019/ubuntu:24.04

RUN apt-get -y install  nodejs

RUN apt-get -y install  openjdk-21-jdk

RUN apt-get -y install  maven

RUN apt-get -y install  git

RUN apt-get -y install  golang

RUN apt-get -y install  curl

RUN apt-get -y install  wget

RUN apt-get -y install apt-transport-https ca-certificates curl software-properties-common
RUN curl -fsSL http://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | apt-key add -
RUN add-apt-repository -y "deb [arch=amd64] http://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"
RUN apt-get update
RUN apt-get -y install docker-ce



RUN chmod 755 /*.sh