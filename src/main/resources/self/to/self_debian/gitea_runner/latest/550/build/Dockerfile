FROM docker:5001/king019/ubuntu:p
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install nodejs
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install openjdk-21-jdk
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install maven
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install git
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install golang
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install curl
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install ca-certificates curl gnupg lsb-release
RUN source /etc/profile;chmod 755 /*.sh;curl -fsSL https://mirrors.aliyun.com/docker-ce/linux/ubuntu/gpg | gpg --dearmor -o /usr/share/keyrings/aliyun-docker-archive-keyring.gpg
RUN source /etc/profile;chmod 755 /*.sh;echo 'deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/aliyun-docker-archive-keyring.gpg] https://mirrors.aliyun.com/docker-ce/linux/ubuntu $(lsb_release -cs) stable' | tee /etc/apt/sources.list.d/docker.list > /dev/null
RUN source /etc/profile;chmod 755 /*.sh;apt-get update
RUN source /etc/profile;chmod 755 /*.sh;apt-get -y install docker-ce


RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
