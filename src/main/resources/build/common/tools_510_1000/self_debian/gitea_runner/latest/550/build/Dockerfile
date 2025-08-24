FROM king019/ubuntu:p

RUN apt-get -y install  nodejs

RUN apt-get -y install  openjdk-21-jdk

RUN apt-get -y install  maven

RUN apt-get -y install  git

RUN apt-get -y install  golang

RUN apt-get -y install  curl

RUN apt-get -y install ca-certificates curl gnupg lsb-release
RUN curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | gpg --dearmor -o /usr/share/keyrings/aliyun-docker-archive-keyring.gpg
RUN echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/aliyun-docker-archive-keyring.gpg] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
RUN apt-get update
RUN apt-get -y install docker-ce



RUN chmod 755 /*.sh