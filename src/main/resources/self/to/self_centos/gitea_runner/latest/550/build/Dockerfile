FROM docker:5001/king019/rhel:p

RUN source /etc/profile;chmod 755 /*.sh;dnf -y install nodejs
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install java-21-openjdk-devel
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install maven
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install git
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install go
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install curl
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install yum-utils
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install device-mapper-persistent-data
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install lvm2
RUN source /etc/profile;chmod 755 /*.sh;dnf config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
RUN source /etc/profile;chmod 755 /*.sh;dnf -y install docker-ce

RUN source /etc/profile;chmod 755 /*.sh;chmod 755 /*.sh
