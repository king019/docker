FROM king019/ubuntu:p

RUN apt-get -y install  nodejs

RUN apt-get -y install  openjdk-21-jdk

RUN apt-get -y install  maven

RUN apt-get -y install  git

RUN apt-get -y install  golang

#RUN echo 'export JAVA_HOME=/usr/lib/jvm/openjdk-21' >> /etc/profile
#RUN echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /etc/profile
#RUN echo '#jdk' >> /etc/profile


RUN apt-get -y install  curl


RUN apt-get -y update
RUN apt-get -y install apt-transport-https ca-certificates curl software-properties-common
RUN curl -fsSL http://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | apt-key add -
RUN add-apt-repository -y "deb [arch=amd64] http://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable"
RUN apt-get -y update
RUN apt-get -y install docker-ce












RUN chmod 755 /*.sh